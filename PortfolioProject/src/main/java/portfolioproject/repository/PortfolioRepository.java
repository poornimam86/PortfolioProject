package portfolioproject.repository;

import portfolioproject.model.Portfolio;
import portfolioproject.util.JsonUtil;

public class PortfolioRepository {

    private static final String FILE_NAME = "portfolio.json";

    public void savePortfolio(Portfolio portfolio) {
        JsonUtil.savePortfolio(portfolio, FILE_NAME);
    }

    public Portfolio loadPortfolio() {
        return JsonUtil.loadPortfolio(FILE_NAME);
    }
}