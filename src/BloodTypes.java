public enum BloodTypes {
    O_MINUS("O-", 30),
    O_PLUS("O+", 15),
    B_MINUS("B-", 10),
    B_PLUS("B+", 5),
    A_MINUS("A-", 6),
    A_PLUS("A+", 3),
    AB_MINUS("AB-", 2),
    AB_PLUS("AB+", 1);

    BloodTypes(String type, int compNum) {
        this.type = type;
        this.compNum = compNum;
    }

    final String type;
    final int compNum;

    /**
     * @param type název krevní skupiny ve tvaru Napr: A-
     * @return enumized bloodType
     */
    public static String getEnumByString(String type) {
        for (BloodTypes e : BloodTypes.values()) {
            if (e.type.equals(type)) return e.name();
        }
        return "AB_PLUS";
    }
}
