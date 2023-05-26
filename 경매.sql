--------------------------------------------------------
--  ������ ������ - �ݿ���-5��-26-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AUCTION
--------------------------------------------------------

  CREATE TABLE "SCOTT"."AUCTION" 
   (	"AID" NUMBER(8,0), 
	"PRODUCTID" NUMBER(8,0), 
	"AUCTIONEER" VARCHAR2(20 BYTE), 
	"BIDDER" VARCHAR2(20 BYTE), 
	"PASSBID" NUMBER(20,0) DEFAULT 0, 
	"NOWBID" NUMBER(20,0) DEFAULT 0, 
	"BIDCOUNT" NUMBER(20,0) DEFAULT 0, 
	"SUCCESSBID" NUMBER(20,0) DEFAULT 0, 
	"AUCTIONSTART" TIMESTAMP (6) DEFAULT systimestamp, 
	"AUCTIONEND" TIMESTAMP (6) DEFAULT systimestamp, 
	"AUCTIONNAME" VARCHAR2(50 CHAR), 
	"STATUS" NUMBER(4,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into SCOTT.AUCTION
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index AU_ID_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."AU_ID_PK" ON "SCOTT"."AUCTION" ("AID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger AUCTION_TRG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE TRIGGER "SCOTT"."AUCTION_TRG" 
BEFORE INSERT ON AUCTION 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.AID IS NULL THEN
      SELECT AUCTION_SEQ.NEXTVAL INTO :NEW.AID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "SCOTT"."AUCTION_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table AUCTION
--------------------------------------------------------

  ALTER TABLE "SCOTT"."AUCTION" MODIFY ("AUCTIONEER" CONSTRAINT "AU_ACNEER_NN" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."AUCTION" MODIFY ("BIDDER" CONSTRAINT "AU_BIR_NN" NOT NULL ENABLE);
  ALTER TABLE "SCOTT"."AUCTION" ADD CONSTRAINT "AU_ID_PK" PRIMARY KEY ("AID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table AUCTION
--------------------------------------------------------

  ALTER TABLE "SCOTT"."AUCTION" ADD CONSTRAINT "AU_PID_FK" FOREIGN KEY ("PRODUCTID")
	  REFERENCES "SCOTT"."AUCTIONPRODUCTS" ("PRODUCTID") ENABLE;
