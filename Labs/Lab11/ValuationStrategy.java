package com.portfolio.patterns;

import com.portfolio.model.Stock;

public interface ValuationStrategy {

    double calculateValue(Stock stock);

}
