import static org.mockito.Mockito.*;

import java.util.List;
import java.util.ArrayList;

public class PortfolioTester {
    Portfolio portfolio;
    StockService stockService;

    public static void main(String[] args) {
        PortfolioTester tester = new PortfolioTester();
        tester.setUp();
        System.out.println(tester.testMarketValue()?"pass":"fail");

    }

    public void setUp(){
        //create a portfolio object to be tested
        portfolio = new Portfolio();
        //create the mock object of stock service
        stockService = mock(StockService.class);
        // set the stockService to the portfolio
        portfolio.setStockService(stockService);

    }

    public boolean testMarketValue(){

        //Creates a list of stocks to be added to portfolio
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock microsoftStock = new Stock("2", "Microsoft", 100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        //add stocks to portfolio
        portfolio.setStocks(stocks);

        //mock the behaviour of the stock service to return the value of the various stocks
        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();
        return marketValue == 100500.00;
    }



}
