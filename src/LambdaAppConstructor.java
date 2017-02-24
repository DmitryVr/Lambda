/**
 * при использовании конструкторов методы
 * функциональных интерфейсов должны принимать
 * тот же список параметров, что и конструкторы класса,
 * и должны возвращать объект данного класса
 */
public class LambdaAppConstructor {
    public static void main(String[] args) {
        UserBuilder userBuilder = User::new;

        User user = userBuilder.create("Tom");
        System.out.println(user.getName());
    }
}

interface UserBuilder {
    User create(String name);
}

class User {
    private String name;

    String getName(){
        return name;
    }

    User(String n){
        this.name = n;
    }
}