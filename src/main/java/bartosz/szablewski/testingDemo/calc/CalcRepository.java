package bartosz.szablewski.testingDemo.calc;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface CalcRepository extends CrudRepository<CalcEntity, UUID> {

//    Collection<CalcEntity> findRejectedCalcs(UUID userId);

}
