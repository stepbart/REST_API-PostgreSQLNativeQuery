package pl.suncode.recruitmentTask.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "tabela_testowa")
public class TestTable {

    @Id
    private Long id;
    @Column
    private String kolumna1;
    @Column
    private String kolumna2;
    @Column
    private String kolumna3;
    @Column
    private Long kolumna4;

    public Object getKolumna(int number) {
        if (number == 1){
            return kolumna1;
        }
        else if (number == 2){
            return kolumna2;
        }
        else if (number == 3){
            return kolumna3;
        }
        else return null;
    }

    @Override
    public String toString() {
        return "TestTable{" +
                "id=" + id +
                ", kolumna1='" + kolumna1 + '\'' +
                ", kolumna2='" + kolumna2 + '\'' +
                ", kolumna3='" + kolumna3 + '\'' +
                ", kolumna4=" + kolumna4 +
                '}';
    }
}
