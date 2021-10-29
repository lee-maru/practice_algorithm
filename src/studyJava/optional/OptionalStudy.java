package studyJava.optional;

import java.util.*;

public class OptionalStudy {

    public static class Car {
        String modelName; // 모델 이름
        String ownerName; // 차 주인 이름

        public Car(String modelName, String ownerName) {
            this.modelName = modelName;
            this.ownerName = ownerName;
        } // 생성자

        public Optional<String> findOwnerName() {
            return Optional.ofNullable(ownerName);
        }

        public String getModelName() {
            return modelName;
        }
    }

    public static class PersonInfo {
        String name;
        String phoneNumber;
        String homeAddress;

        public PersonInfo(String name, String phoneNumber, String homeAddress) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.homeAddress = homeAddress;
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return name + "/" + phoneNumber + "/" + homeAddress;
        }
    }

    private static void printCarNameAndOwner(String modelName, String ownerName) {
        System.out.println(modelName + "의 차량 주인은 " + ownerName + "입니다.");
    }

    private static Optional<PersonInfo> findPersonInfoByName(String ownerName, List<PersonInfo> personInfos) {
        // gouava
        if (ownerName == null) {
            return Optional.empty();
        }

        for (PersonInfo personInfo : personInfos) {
            if (ownerName.equals(personInfo.getName()))
                return Optional.of(personInfo);
        }

        return Optional.empty();
    }


    public static void main(String[] args) {
        List<PersonInfo> personInfos = new ArrayList<>();
        personInfos.add(new PersonInfo("철수", "010-1234-1234", "서울"));
        personInfos.add(new PersonInfo("엘론머스크", "010-4321-4321", "화성"));
        personInfos.add(new PersonInfo("짱구", "010-5678-5678", "떡잎마을"));

        Car redCar = new Car("테슬라 model-X", "철수");
        Car blueCar = new Car("테슬라 model-S", null); // 대포 차량
        Car blackCar = new Car("테슬라 model-Y", "엘론머스크");

        redCar.findOwnerName().ifPresent(name -> printCarNameAndOwner(redCar.modelName, name));
        // monad
        Optional<PersonInfo> personInfo = redCar.findOwnerName().flatMap(name -> findPersonInfoByName(name, personInfos));
        personInfo.ifPresent(System.out::println);







    /*    redCar.findOwnerName().ifPresent(name -> printCarNameAndOwner(redCar.getModelName(), name)); // void 메서드에서의 Optional 사용 (Consumer)
        blueCar.findOwnerName().ifPresent(name -> printCarNameAndOwner(blueCar.getModelName(), name)); // 실행 안됨

        Optional<PersonInfo> personInfoByName = findPersonInfoByName(redCar.findOwnerName().orElse(null), personInfos);

        Optional<Optional<PersonInfo>> personInfo1 = redCar.findOwnerName().map(name -> findPersonInfoByName(name, personInfos));

        Optional<PersonInfo> personInfo = redCar.findOwnerName().flatMap(name -> findPersonInfoByName(name, personInfos));
        personInfo.ifPresent(System.out::println);

        Optional<PersonInfo> personInfo2 = blueCar.findOwnerName().flatMap(name -> findPersonInfoByName(name, personInfos));
        personInfo2.ifPresent(System.out::println);
*/
    }
}