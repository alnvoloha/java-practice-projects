package util;

import entity.DigitStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberReverser implements Reversible {
    private static final Logger logger = LogManager.getLogger(NumberReverser.class);

    public DigitStack toStack(String number) {
        DigitStack digitStack = new DigitStack();
        for (char ch : number.toCharArray()) {
            digitStack.pushDigit(ch);
        }
        logger.info("Число занесено в стек: {}", number);
        return digitStack;
    }

    public String reverse(DigitStack stack) {
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.popDigit());
        }
        logger.info("Число перевёрнуто: {}", reversed);
        return reversed.toString();
    }

    @Override
    public String reverse(String input) {
        return reverse(toStack(input));
    }
}
