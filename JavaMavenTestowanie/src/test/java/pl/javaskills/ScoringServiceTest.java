package pl.javaskills;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("testing scoring depending on age")
class ScoringServiceTest {
    //private ScoringService cut=new ScoringService();
    //cut - Class Under Test
    @InjectMocks //utowrzy instancje
    private ScoringService cut;

    @Mock
    private AdditionalPointsService additionalPointsServiceMock;

    @Test
    @DisplayName("should return -100 when age < 18")
    @ExtendWith(MockitoExtension.class)
    public void shouldReturnMinus100PointsWhenAgeIsLessThan18(){
        //bbd - technika
        //given
        int age=17;
        //when
        int result=cut.calculate(age);
        //then
        Mockito.verifyNoInteractions(additionalPointsServiceMock);
        assertEquals(-100,result);

    }

    @Test
    @DisplayName("should return -200 when age < 60")
    @ExtendWith(MockitoExtension.class)
    public void shouldReturnMinus200PointsWhenAgeIsLessThan60(){
        //bbd - technika
        //given
        int age=65;
        //when
        int result=cut.calculate(age);
        //then
        Mockito.verifyNoInteractions(additionalPointsServiceMock);
        assertEquals(-200,result);

    }

    @Test
    @DisplayName("should return 0 when age >=18 && <=60")
    @ExtendWith(MockitoExtension.class)
    public void shouldReturn0PointsWhenAgeIsLessThan18(){
        //bbd - technika
        //given
        int age=40;
        int additionalPoints=100;
        BDDMockito.given(additionalPointsServiceMock.getAdditionalPoints()).willReturn(additionalPoints);
        //when
        int result=cut.calculate(age);
        //then
        Mockito.verify(additionalPointsServiceMock,Mockito.times(1)).getAdditionalPoints();
        assertEquals(100,result);

    }

}