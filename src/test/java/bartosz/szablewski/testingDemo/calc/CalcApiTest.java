package bartosz.szablewski.testingDemo.calc;

import bartosz.szablewski.testingDemo.user.UserApi;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class CalcApiTest {

    private CalcApi calcApi;
    private CalcRepository calcRepository;
    private CalcEntityBuilder calcEntityBuilder;
    @Mock
    private UserApi userApi;

    @BeforeEach
    public void setUp() {
        calcRepository = new CalcTestRepository();

        calcApi = new CalcApi(new CalcService(new CalcValidator(), userApi, calcRepository));

        calcEntityBuilder = CalcEntityBuilder.aCalcEntity(calcRepository);

//        given(userApi.verifyUser(anyInt())).willReturn(true);
    }

//    @Test
//    public void calculate_returnsRating_forAdult() {
//        //when
//        int result = calcApi.calculateRating(22);
//
//        //then
//        assertThat(result).isEqualTo(44);
//    }
//
//    @Test
//    public void calculate_savesRating() {
//        //when
//        int result = calcApi.calculateRating(22);
//
//        //then
//        assertThat(result).isEqualTo(44);
//        assertThat(calcRepository.findAll()).hasSize(1);
//    }

    @Test
    public void calculate_returnsZero_forNotAdult() {
        //when
        int result = calcApi.calculateRating(2);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void calculate_returnsZero_forNotPermittedAdultUser() {
        //given
        given(userApi.verifyUser(anyInt())).willReturn(false);

        //when
        int result = calcApi.calculateRating(23);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void demo_storesCalcInDb() {
        //when
        CalcEntity calcEntity = calcEntityBuilder.inDb();

        //then
        assertThat(calcRepository.findById(calcEntity.getId())).isNotEmpty();
    }
}
