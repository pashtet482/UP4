import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RecruitmentAgencyTest {

    @Test
    public void testFindVacancies_withMatchingCriteria() {
        
        String name = "Иван";
        String position = "Инженер";
        String employment = "Штат";
        String education = "Высшее";
        String specialty = "Инженер";
        
        String expected = "Уважаемый(ая) Иван, подходящие вакансии:\n" +
                          "- Инженер: 100,000 руб.\n";
       
        String result = RecruitmentAgency.findVacancies(name, position, employment, education, specialty);

       
        assertEquals(expected, result);
    }
   
    @Test
    public void testFindVacancies_noMatchingVacancies() {
        // Пример данных
        String name = "Мария";
        String position = "Юрист";
        String employment = "ГПХ";
        String education = "Среднее";
        String specialty = "Дизайнер";

        
        String expected = "Уважаемый(ая) Мария, подходящие вакансии:\n" +
                          "Нет подходящих вакансий.";

        
        String result = RecruitmentAgency.findVacancies(name, position, employment, education, specialty);

        
        assertEquals(expected, result);
    }

   
    @Test
    public void testFindVacancies_withEmptyFields() {
        
        String name = "";
        String position = "Программист";
        String employment = "Штат";
        String education = "Высшее";
        String specialty = "Программист";

        
        String expected = "Пожалуйста, заполните все поля!";

       
        String result = RecruitmentAgency.findVacancies(name, position, employment, education, specialty);

       
        assertEquals(expected, result);
    }

   
    @Test
    public void testFindVacancies_withPartialFields() {
       
        String name = "Анна";
        String position = "Маркетолог";
        String employment = null;
        String education = "Среднее";
        String specialty = "Маркетолог";

       
        String expected = "Пожалуйста, заполните все поля!";

        
        String result = RecruitmentAgency.findVacancies(name, position, employment, education, specialty);

        
        assertEquals(expected, result);
    }
}
