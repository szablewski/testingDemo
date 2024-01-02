package bartosz.szablewski.testingDemo.calc;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "calculations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
class CalcEntity {

    @Id
    @Column(updatable = false, nullable = false, name = "id")
    private UUID id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "result")
    private Integer result;
}
