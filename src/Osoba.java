public class Osoba {
    String name;
    int height,
            weight,
            age;
    BloodTypes bloodType;
    int bloodCap;

    public Osoba(String name, int height, int weight, int age, BloodTypes bloodType) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.bloodType = bloodType;
        bloodCap = 3;
    }

    @Override
    public String toString() {
        return "Donator{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", bloodType=" + bloodType +
                '}';
    }

    /**
     *
     * @param bt person's blood type
     * @return true if this person is compatible (is able to donate blood) to the 2nd person
     */
    boolean canDonate(BloodTypes bt) {
        //H.B.: great approach! instant resolution using only one compare and Boole algebra at that
        return (this.bloodType.compNum % bt.compNum == 0);
    }

    /**
     *
     * @param o instance of a person class
     * @return true if donation was successful
     */
    boolean donateBlood(Osoba o) {
        if (canDonate(o.bloodType)) {
            bloodCap--;
            String toPrint = name + " úspěšně daroval krev " + bloodType.type + " [" + bloodCap + "/3] " + o.name;
            if(bloodCap == 0) toPrint = toPrint.concat(" a došla mu krev, je vyškrnutý");
            System.out.println(toPrint);
            return true;
        } else System.out.println(name + " neúspěšně daroval krev " + o.name);
        return false;
    }
}
