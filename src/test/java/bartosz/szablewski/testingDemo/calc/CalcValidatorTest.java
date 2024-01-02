package bartosz.szablewski.testingDemo.calc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcValidatorTest {

    CalcValidator calcValidator;

    @BeforeEach
    public void setUp() {
        calcValidator = new CalcValidator();
    }

    @Test
    public void ageValidation_returnsValid() {

        assertThat(calcValidator.ageIsValid(18)).isTrue();
        assertThat(calcValidator.ageIsValid(33)).isTrue();
        assertThat(calcValidator.ageIsValid(Integer.MAX_VALUE)).isTrue();
    }

    @Test
    public void ageValidation_returnsNotValid() {

        assertThat(calcValidator.ageIsValid(17)).isFalse();
        assertThat(calcValidator.ageIsValid(0)).isFalse();
        assertThat(calcValidator.ageIsValid(Integer.MIN_VALUE)).isFalse();
    }
}