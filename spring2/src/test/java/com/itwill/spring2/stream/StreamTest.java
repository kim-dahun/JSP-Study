package com.itwill.spring2.stream;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

// 스프링 컨텍스(application-context.xml 또는 servlet-context.xml)를 사용하지 않는
// 단위 테스트에서는 @ExtentWith, @ContextConfiguration 애너테이션 사용할 필요 X
public class StreamTest {

    @Test
    public void test() {
        
        
        List<Integer> numbers = Arrays.asList(1,2,6,4,5,3,7);
        
        // numbers 에서 홀수들만 필터링한 결과
        List<Integer> odds = numbers.stream().filter((x) -> (x%2==1)).toList();
        System.out.println(odds);
        
        // numbers 의 원소들의 제곱을 만들기
        List<Integer> squares = numbers.stream().map((x)->(x*x)).toList();
        System.out.println(squares);
        
        // numbers 의 원소 중 홀수들의 제곱.
        List<Integer> oddSquares = numbers.stream().filter((x)->{ return x%2==1; }).map((x)->(x*x)).toList();
        System.out.println(oddSquares);
        
        List<String> languages = Arrays.asList("Java","JavaScript","SQL");
        System.out.println(languages);
        
        // Languages가 가지고 있는 문자열들의 길이를 원소로 갖는 리스트 만들기 
        List<Integer> lengths = languages.stream().map(String::length).toList();
        System.out.println(lengths);
        
        List<LocalDateTime> times = Arrays.asList(LocalDateTime.of(2023, 5, 23, 11, 30, 0),
                LocalDateTime.of(2023, 5, 22, 18, 30, 0),LocalDateTime.of(2023, 5, 21, 17, 30, 0));
        
        // LocalDateTime -> Timestamp 로 변환
        List<Timestamp> convtimes = times.stream().map(Timestamp::valueOf).toList();
        System.out.println(convtimes);
        
    }
    
}
