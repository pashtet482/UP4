import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecruitmentAgency {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Кадровое агентство");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        frame.setLayout(new GridLayout(8, 2, 10, 10));

        JLabel nameLabel = new JLabel("Имя:");
        JTextField nameField = new JTextField();

        JLabel positionLabel = new JLabel("Искомая должность:");
        JComboBox<String> positionBox = new JComboBox<>(new String[]{"Менеджер", "Программист", "Дизайнер", "Маркетолог", "Системный администратор", "Юрист", "Экономист", "Тестировщик"});

        JLabel employmentLabel = new JLabel("Тип занятости:");
        JRadioButton fullTimeButton = new JRadioButton("Штат");
        JRadioButton freelanceButton = new JRadioButton("ГПХ");
        ButtonGroup employmentGroup = new ButtonGroup();
        employmentGroup.add(fullTimeButton);
        employmentGroup.add(freelanceButton);
        
        fullTimeButton.setSelected(true);

        JLabel educationLabel = new JLabel("Образование:");
        JRadioButton higherButton = new JRadioButton("Высшее");
        JRadioButton secondaryButton = new JRadioButton("Среднее");
        ButtonGroup educationGroup = new ButtonGroup();
        educationGroup.add(higherButton);
        educationGroup.add(secondaryButton);
        
        higherButton.setSelected(true);

        JLabel specialtyLabel = new JLabel("Специальность:");
        JComboBox<String> specialtyBox = new JComboBox<>(new String[]{"Инженер", "Юрист", "Экономист", "Маркетолог", "Системный администратор", "Дизайнер", "Тестировщик", "Контент-менеджер"});

        JButton resultButton = new JButton("Показать вакансии");

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(positionLabel);
        frame.add(positionBox);
        frame.add(employmentLabel);
        frame.add(fullTimeButton);
        frame.add(new JLabel());
        frame.add(freelanceButton);
        frame.add(educationLabel);
        frame.add(higherButton);
        frame.add(new JLabel());
        frame.add(secondaryButton);
        frame.add(specialtyLabel);
        frame.add(specialtyBox);
        frame.add(resultButton);

        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String position = (String) positionBox.getSelectedItem();
                String employment = fullTimeButton.isSelected() ? "Штат" : (freelanceButton.isSelected() ? "ГПХ" : null);
                String education = higherButton.isSelected() ? "Высшее" : (secondaryButton.isSelected() ? "Среднее" : null);
                String specialty = (String) specialtyBox.getSelectedItem();

                if (name.isEmpty() || employment == null || education == null || specialty == null || specialty.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Пожалуйста, заполните все поля!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String result = findVacancies(name, position, employment, education, specialty);
                JOptionPane.showMessageDialog(frame, result, "Результат", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    public static String findVacancies(String name, String position, String employment, String education, String specialty) {
        if (name == null || name.isEmpty() || employment == null || education == null || specialty == null || specialty.isEmpty()) {
            return "Пожалуйста, заполните все поля!";
        }

        String[][] vacancies = {
        		
        	{"Менеджер", "Штат", "Высшее", "100,000 руб.", "Инженер"},
            {"Менеджер", "Штат", "Среднее", "80,000 руб.", "Юрист"},
            {"Менеджер", "ГПХ", "Высшее", "90,000 руб.", "Экономист"},
            {"Менеджер", "ГПХ", "Среднее", "85,000 руб.", "Маркетолог"},
            {"Менеджер", "Штат", "Высшее", "100,000 руб.", "Системный администратор"},
            {"Менеджер", "Штат", "Среднее", "80,000 руб.", "Дизайнер"},
            {"Менеджер", "ГПХ", "Высшее", "90,000 руб.", "Тестировщик"},
            {"Менеджер", "ГПХ", "Среднее", "85,000 руб.", "Контент-менеджер"},
        		
            {"Инженер", "Штат", "Высшее", "100,000 руб.", "Инженер"},
            {"Инженер", "Штат", "Среднее", "80,000 руб.", "Инженер"},
            {"Инженер", "ГПХ", "Высшее", "90,000 руб.", "Инженер"},
            {"Инженер", "ГПХ", "Среднее", "85,000 руб.", "Инженер"},

            {"Юрист", "Штат", "Высшее", "90,000 руб.", "Юрист"},
            {"Юрист", "Штат", "Среднее", "80,000 руб.", "Юрист"},
            {"Юрист", "ГПХ", "Высшее", "85,000 руб.", "Юрист"},
            {"Юрист", "ГПХ", "Среднее", "75,000 руб.", "Юрист"},

            {"Экономист", "Штат", "Высшее", "70,000 руб.", "Экономист"},
            {"Экономист", "Штат", "Среднее", "60,000 руб.", "Экономист"},
            {"Экономист", "ГПХ", "Высшее", "65,000 руб.", "Экономист"},
            {"Экономист", "ГПХ", "Среднее", "55,000 руб.", "Экономист"},

            {"Маркетолог", "Штат", "Высшее", "80,000 руб.", "Маркетолог"},
            {"Маркетолог", "Штат", "Среднее", "70,000 руб.", "Маркетолог"},
            {"Маркетолог", "ГПХ", "Высшее", "75,000 руб.", "Маркетолог"},
            {"Маркетолог", "ГПХ", "Среднее", "65,000 руб.", "Маркетолог"},

            {"Системный администратор", "Штат", "Высшее", "120,000 руб.", "Системный администратор"},
            {"Системный администратор", "Штат", "Среднее", "100,000 руб.", "Системный администратор"},
            {"Системный администратор", "ГПХ", "Высшее", "110,000 руб.", "Системный администратор"},
            {"Системный администратор", "ГПХ", "Среднее", "90,000 руб.", "Системный администратор"},

            {"Дизайнер", "Штат", "Высшее", "70,000 руб.", "Дизайнер"},
            {"Дизайнер", "Штат", "Среднее", "60,000 руб.", "Дизайнер"},
            {"Дизайнер", "ГПХ", "Высшее", "65,000 руб.", "Дизайнер"},
            {"Дизайнер", "ГПХ", "Среднее", "55,000 руб.", "Дизайнер"},

            {"Тестировщик", "Штат", "Высшее", "80,000 руб.", "Тестировщик"},
            {"Тестировщик", "Штат", "Среднее", "70,000 руб.", "Тестировщик"},
            {"Тестировщик", "ГПХ", "Высшее", "75,000 руб.", "Тестировщик"},
            {"Тестировщик", "ГПХ", "Среднее", "65,000 руб.", "Тестировщик"},

            {"Контент-менеджер", "Штат", "Высшее", "50,000 руб.", "Контент-менеджер"},
            {"Контент-менеджер", "Штат", "Среднее", "45,000 руб.", "Контент-менеджер"},
            {"Контент-менеджер", "ГПХ", "Высшее", "55,000 руб.", "Контент-менеджер"},
            {"Контент-менеджер", "ГПХ", "Среднее", "40,000 руб.", "Контент-менеджер"}
        };

        StringBuilder result = new StringBuilder("Уважаемый(ая) " + name + ", подходящие вакансии:\n");
        boolean found = false;

        for (String[] vacancy : vacancies) {
            if (vacancy[0].equals(position) && vacancy[1].equals(employment) && vacancy[2].equals(education) && vacancy[4].equals(specialty)) {
                result.append("- ").append(vacancy[0]).append(": ").append(vacancy[3]).append("\n");
                found = true;
            }
        }

        if (!found) {
            result.append("Нет подходящих вакансий.");
        }

        return result.toString();
    }
}
