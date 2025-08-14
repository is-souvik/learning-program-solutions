package mytests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Pass mock to service
        MyService service = new MyService(mockApi);

        // Call method
        String result = service.fetchData();

        // Assert result
        assertEquals("Mock Data", result);
    }
}