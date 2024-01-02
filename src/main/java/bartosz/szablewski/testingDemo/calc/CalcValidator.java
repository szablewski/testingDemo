package bartosz.szablewski.testingDemo.calc;

import org.springframework.stereotype.Component;

@Component
class CalcValidator {

    boolean ageIsValid(int age){
        return age >= 18;
    }
}
