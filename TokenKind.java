
/**
 * Token kinds needed for Part 1 of the Core Interpreter project.
 *
 * @author Wayne D. Heym
 *
 */
enum TokenKind {

    /**
     * Test driver's token number = 1-11; token is one of the reserved words.
     */
    PROGRAM(1),
    BEGIN(2),
    END(3),
    INT(4),
    IF(5),
    THEN(6),
    ELSE(7),
    WHILE(8),
    LOOP(9),
    READ(10),
    WRITE(11),

    /**
     * Test driver's token number = 12; token is ;.
     */
    SEMICOLON(12),

    /**
     * Test driver's token number = 12; token is ,.
     */
    COMMA(13),

    /**
     * Test driver's token number = 14; token is =.
     */
    ASSIGNMENT_OPERATOR(14),

    /**
     * Test driver's token number = 15; token is !.
     */
    NEGATION(15),

    /**
     * Test driver's token number = 16; token is [.
     */
    L_BRACKET(16),

    /**
     * Test driver's token number = 17; token is ].
     */
    R_BRACKET(17),

    /**
     * Test driver's token number = 18; token is &&.
     */
    AND_OPERATOR(18),

    /**
     * Test driver's token number = 19; token is ||.
     */
    OR_OPERATOR(19),

    /**
     * Test driver's token number = 20; token is (.
     */
    L_PAREN(20),

    /**
     * Test driver's token number = 21; token is ).
     */
    R_PAREN(21),

    /**
     * Test driver's token number = 22; token is +.
     */
    PLUS(22),

    /**
     * Test driver's token number = 23; token is -.
     */
    MINUS(23),

    /**
     * Test driver's token number = 24; token is *.
     */
    TIMES(24),

    /**
     * Test driver's token number = 25; token is !=.
     */
    UNEQUAL_TEST(25),

    /**
     * Test driver's token number = 26; token is ==.
     */
    EQUALITY_TEST(26),

    /**
     * Test driver's token number = 27; token is <.
     */
    LESS(27),

    /**
     * Test driver's token number = 28; token is >.
     */
    GREATER(28),

    /**
     * Test driver's token number = 29; token is <=.
     */
    LESS_EQUAL(29),

    /**
     * Test driver's token number = 30; token is >=.
     */
    GREATER_EQUAL(30),

    /**
     * Test driver's token number = 31.
     */
    INTEGER_CONSTANT(31),

    /**
     * Test driver's token number = 32.
     */
    IDENTIFIER(32),

    /**
     * Test driver's token number = 33.
     */
    EOF(33),

    /**
     * Test driver's token number = 34.
     */
    ERROR(34);

    /**
     * Test driver's token number.
     */
    private final int testDriverTokenNumber;

    /**
     * Constructor. (As class TokenKind is an enum, the visibility of the
     * explicit constructor is automatically private (i.e., private by default).
     * The default visibility for it is not package visibility.)
     *
     * @param number
     *            the test driver's token number
     */
    TokenKind(int number) {
        this.testDriverTokenNumber = number;
    }

    /**
     * Return test driver's token number.
     *
     * @return test driver's token number
     */
    public int testDriverTokenNumber() {
        return this.testDriverTokenNumber;
    }

}
