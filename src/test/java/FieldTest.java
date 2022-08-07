import com.example.heatos.model.Field;
import com.example.heatos.model.TemperatureBlock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    public Field field;

    @BeforeEach
    void beforeAll() {
       field = new Field(3);
    }

    @Test
    void addBlock() {
        field.addBlock(1, 1, "2");
        assertEquals(new TemperatureBlock(2,1, 1), field.getBlock(1,1));
    }

    @Test
    void move() {
        field.addBlock(1, 1, "2");
        field.setSelectedBlock((TemperatureBlock) field.getBlock(1,1));
        field.move(1,2);
        assertEquals(new TemperatureBlock(1, 1, 2), field.getBlock(1, 2));
    }

    @Test
    void winCheck() {
        field.addBlock(1, 1, "2");
        assertFalse(field.winCheck());
        field.addBlock(1, 2, "-2");
        field.setSelectedBlock((TemperatureBlock) field.getBlock(1,1));
        field.move(1,2);
        assertTrue(field.winCheck());
    }


}