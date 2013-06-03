package net.sf.jfasta.impl;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestHeaderDialectUniprot {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    private HeaderDialectUniprot dia;

    @Before
    public void setUp() throws Exception {
        dia = new HeaderDialectUniprot();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public final void testGetGeneName01() {
        dia.setHeaderString(">sp|Q13085|ACACA_HUMAN Acetyl-CoA carboxylase 1 OS=Homo sapiens GN=ACACA PE=1 SV=2");
        assertEquals("ACACA", dia.getGeneName());
    }

    @Test
    public final void testGetGeneName02() {
        dia.setHeaderString(">sp|P61604|CH10_HUMAN 10 kDa heat shock protein, mitochondrial OS=Homo sapiens GN=HSPE1 PE=1 SV=2");
        assertEquals("HSPE1", dia.getGeneName());
    }

    @Test
    public final void testGetSpeciesName01() {
        dia.setHeaderString(">sp|Q13085|ACACA_HUMAN Acetyl-CoA carboxylase 1 OS=Homo sapiens GN=ACACA PE=1 SV=2");
        assertEquals("Homo sapiens", dia.getSpeciesName());
    }

}