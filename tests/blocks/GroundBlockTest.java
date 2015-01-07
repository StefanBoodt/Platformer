package blocks;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GroundBlockTest extends BlockTest {
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		GroundBlock block = new GroundBlock(0, 0);
		this.setBlock(block);
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

}
