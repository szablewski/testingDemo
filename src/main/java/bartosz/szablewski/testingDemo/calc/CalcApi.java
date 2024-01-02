package bartosz.szablewski.testingDemo.calc;

import bartosz.szablewski.testingDemo.infrastructure.ModuleApi;
import lombok.AllArgsConstructor;

@ModuleApi
@AllArgsConstructor
public class CalcApi {

    private final CalcService calcService;

    public int calculateRating(int age) {
        return calcService.calculateRating(age);
    }
}
