public enum BloodTypes {
    O_MINUS("O-", 30, 5),
    O_PLUS("O+", 15, 4),
    B_MINUS("B-", 10, 3),
    B_PLUS("B+", 5, 2),
    A_MINUS("A-", 6, 1),
    A_PLUS("A+", 3, 0),
    AB_MINUS("AB-", 2, 7),
    AB_PLUS("AB+", 1, 6);

    BloodTypes(String type, int compNum, int position) {
        this.type = type;
        this.compNum = compNum;
        this.position = position;
    }

    final String type;
    final int compNum, position;

    /**
     * boolean table implementation of bloodtypes compatibility.
     * Matrix is diagonally 'true', otherwise follows blood donation compatibility-
     */
    private static final boolean[][] BLOOD_COMPATIBILITY = {
//          A+    A-    B+      B-    0+    0-    AB+    AB-
        { true, true, false, false, true, true, false, false },  // A+
        { false, true, false, false, false, true, false, false}, // A-
        { false, false, true, true, true, true, false, false},   // B+
        { false, false, false, true, false, true, false, false}, // B-
        { false, false, false, false, true, true, false, false}, // 0+
        { false, false, false, false, false, true, false, false},// 0-
        { true, true, true, true, true, true, true, true},       // AB+
        { false, true, false, true, false, true, false, true}    // AB-

};

    /**
     * Alternative approach to donor compatibility test.
     * Uses {@link BloodTypes} table as point of reference.
     * @param blood bloodtype of possible patient in need of donation
     * @return true if blood can be donated
     */
    public boolean canBeDonatedAlternated(BloodTypes blood){
        return BLOOD_COMPATIBILITY[this.position][blood.position];
    }


    /**
     * @param type "short name of a blood group E.g.: O+"
     * @return enumized bloodType
     */
    public static String getEnumByString(String type) {
        for (BloodTypes e : BloodTypes.values()) {
            if (e.type.equals(type)) return e.name();
        }
        return "AB_PLUS";
    }
}
