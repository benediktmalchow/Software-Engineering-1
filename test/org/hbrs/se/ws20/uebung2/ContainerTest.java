package org.hbrs.se.ws20.uebung2;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class ContainerTest {

    private Container c;
    private MemberImplemented m1 = new MemberImplemented(2142141);
    private MemberImplemented m2 = new MemberImplemented(42141241);
    private MemberImplemented m3 = new MemberImplemented(12412412);

    @BeforeEach
    public void initialize() throws ContainerException{
        c = new Container();
        c.addMember(m1);
        c.addMember(m2);
        c.addMember(m3);
    }

    @Test
    void addMember() {
        assertThrows(ContainerException.class, () -> c.addMember(m1));
        assertThrows(ContainerException.class, () -> c.addMember(m2));
        assertThrows(ContainerException.class, () -> c.addMember(m3));
        System.out.println("addMember method console test: ");
        try {
            c.addMember(m1);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        try {
            c.addMember(m2);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        try {
            c.addMember(m3);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteMember() {
        assertEquals("Remove of Member 462352323 not successfull!", c.deleteMember(462352323));
        assertEquals("Remove of Member 2142141 successfull!", c.deleteMember(2142141));
        assertEquals("Remove of Member 42141241 successfull!", c.deleteMember(42141241));
        assertEquals("Remove of Member 12412412 successfull!", c.deleteMember(12412412));
        assertEquals("Remove of Member 46235232 not successfull!", c.deleteMember(46235232));
    }

    @Test
    void dump() {
        System.out.println("dump method console test:");
        c.dump();

    }

    @Test
    void size() {
        assertEquals(3, c.size());
        c.deleteMember(2142141);
        assertEquals(2, c.size());
        c.deleteMember(12412412);
        assertEquals(1, c.size());
        c.deleteMember(42141241);
        assertEquals(0, c.size());
    }
}