package bartosz.szablewski.testingDemo.calc;


import bartosz.szablewski.testingDemo.InMemoryRepository;

import java.util.UUID;

class CalcTestRepository extends InMemoryRepository<CalcEntity, UUID> implements CalcRepository {
    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {}
}
