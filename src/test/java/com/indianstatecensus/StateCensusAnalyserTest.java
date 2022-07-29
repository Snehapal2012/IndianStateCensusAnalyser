package com.indianstatecensus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\DELL\\IdeaProjects\\IndianStateCensusAnalyser\\src\\main\\resources\\IndianStateCensusAnalyser.csv";
    private static final String WRONG_CSV_FILE_PATH ="C:\\Users\\DELL\\IdeaProjects\\IndianStateCensusAnalyser\\src\\test\\resources\\IndianStateCensusData.csv";

    @Test
    public void givenIndianCensusCSVFile_ReturnsCorrectRecords() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assertions.assertEquals(29,numOfRecords);
        } catch (StateCensusAnalyserException e) { }
    }
    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();

            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (StateCensusAnalyserException e) {
            Assertions.assertEquals(StateCensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
}
