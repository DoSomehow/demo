package org.ms.thinkInJava.enumerated;

import org.ms.thinkInJava.util.Enums;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/26 23:44
 */
public enum SecurityCategory {

    STOCK(Security.Stock.class), BOND(Security.Bond.class);

    Security[] values;

    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGIN
        }

        enum Bond implements Security {
            MUNICIPAL, JUNK
        }
    }

    public Security randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": "+ category.randomSelection());
        }
    }


}
