package Integration;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

class TestFIFOLIGEOIS{

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest()
	@MethodSource("add")
	void FifoAdd(int nombre, int resultat) {
		FIFO fifo = new FIFO();
		fifo.add(nombre);
		int first = fifo.first();
		assertEquals(resultat, first);
	}
	
	static Stream<Arguments> add() throws Throwable{
		return Stream.of(Arguments.of(5,5),
						Arguments.of(20,20));
	}

	@ParameterizedTest()
	@MethodSource("testEmpty")
	void FifoEmpty() {
		FIFO fifo = new FIFO();
		assertTrue(fifo.isEmpty());
	}
	
	static Stream<Arguments> testEmpty() throws Throwable{
		return Stream.of(Arguments.of(), 
				Arguments.of(), 
				Arguments.of());
	}
	
	@ParameterizedTest()
	@MethodSource("size")
	void FifoTaille(int nbrs[], int resultat) {
		FIFO fifo = new FIFO();
		for(int nbr: nbrs) {
			fifo.add(nbr);
		}
		int taille = fifo.size();
		assertEquals(resultat, taille);
	}
	
	static Stream<Arguments> size() throws Throwable{
		int[] tab1 = new int[] {5};
		int[] tab2 = new int[] {5,6};
		int[] tab3 = new int[] {5,6,5};
		return Stream.of(Arguments.of(tab1, 1),
						Arguments.of(tab2, 2),
						Arguments.of(tab3, 3));
	}

	@ParameterizedTest()
	@MethodSource("remove")
	void FifoRemoveFirst(int nombre1, int nombre2, int resultat) {
		FIFO fifo = new FIFO();
		fifo.add(nombre1);
		fifo.add(nombre2);
		fifo.removeFirst();
		int removefirst = fifo.first();
		assertEquals(resultat, removefirst );
	}

	static Stream<Arguments> remove() throws Throwable{
		return Stream.of(Arguments.of(1, 2, 2));
	}
}
