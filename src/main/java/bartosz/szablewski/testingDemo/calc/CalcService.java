package bartosz.szablewski.testingDemo.calc;

import bartosz.szablewski.testingDemo.user.UserApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@AllArgsConstructor
class CalcService {

    private CalcValidator calcValidator;
    private UserApi userApi;
    private CalcRepository calcRepository;

    int calculateRating(int age) {

        int rating;

        if (calcValidator.ageIsValid(age)
                && userApi.verifyUser(age)) {
            rating = age * 2;
        } else {
            rating = 0;
        }

        calcRepository.save(new CalcEntity(UUID.randomUUID(), age, rating));
        return rating;
    }
}