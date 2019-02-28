package Integration;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.Assert;

class TriTableauTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@ParameterizedTest()
	@MethodSource("croissant")
	void testTriCroissant(int tabCroi[], int resultat[]) {
		TriTableau.triCroissant(tabCroi);
		Assert.assertArrayEquals(resultat,tabCroi);
	}
	
	static Stream<Arguments> croissant() throws Throwable{
		int[] tab = new int[] {10,26,12,9};
		int[] resultat = new int[] {9,10,12,26};
		int[] tab2 = new int[] {123,180,8,200};
		int[] resultat2 = new int[] {8,123,180,200};
		return Stream.of(Arguments.of(tab, resultat),
						Arguments.of(tab2, resultat2));
	}


}