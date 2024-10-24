package lab_3c;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
public class ServiceTestCases {

	
    private Service service;
    private Database mockDatabase;
    
    @BeforeEach
    void setUp() {
        
        mockDatabase = Mockito.mock(Database.class);
        

        service = new Service(mockDatabase);
    }

    @Test
    void testDatabaseID() {
       
        when(mockDatabase.getUniqueId()).thenReturn(123);

        String result = service.getDatabaseID();

        verify(mockDatabase).getUniqueId();  

        assertEquals("123", result);
    }
    

    @Test
    public void testQuery() {
        Mockito.when(mockDatabase.isAvailable()).thenReturn(true);
        boolean isAvailable = service.query("something query");
        assertEquals(true, isAvailable);
    }
}
