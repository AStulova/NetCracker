package app.service;

import app.model.User;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    String dataBase = "src\\main\\resources\\dataBase.txt";

    private boolean validate(String s) {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]+$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public void addUser(User user) throws ValidationException, IOException {
        StringBuffer stringBuffer = new StringBuffer();
        if(validate(user.getSurname()) && validate(user.getName()) && validate(user.getPatronymic())) {
            stringBuffer.append(user.getSurname() + "/" + user.getName() + "/" + user.getPatronymic()
                    + "/" + user.getAge() + "/" + user.getSalary() + "/" + user.getEmail() + "/" + user.getJob() + "_");
        }
        else {
            throw new ValidationException("Error! Wrong format!");
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dataBase, true));
        bufferedWriter.append(stringBuffer.toString());
        bufferedWriter.close();
    }

    public User findUser(User user) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(dataBase)).useLocale(Locale.US);
        scanner.useDelimiter("[/_]");
        while (scanner.hasNext()) {
            User newUser = new User(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextDouble(), scanner.next(), scanner.next());
            if (user.getSurname().equals(newUser.getSurname())
                    && user.getName().equals(newUser.getName())) {
                scanner.close();
                return newUser;
            }
        }
        scanner.close();
        return null;
    }

    public void addUser(String path) throws IOException, ValidationException {
        Scanner scanner = new Scanner(new File(path)).useLocale(Locale.US);
        scanner.useDelimiter("[/_]");
        if(scanner.hasNext()) {
            User newUser = new User(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextDouble(), scanner.next(), scanner.next());
            addUser(newUser);
        }
        scanner.close();
    }
}
