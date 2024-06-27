package bg.softuni.mobilele.models.dtos;

import java.math.BigDecimal;
import java.util.Map;

public class ExRatesDTO {
   private String base;
   private Map<String, BigDecimal> rates;

   public ExRatesDTO() {
   }

   public String getBase() {
      return base;
   }

   public ExRatesDTO setBase(String base) {
      this.base = base;
      return this;
   }

   public Map<String, BigDecimal> getRates() {
      return rates;
   }

   public ExRatesDTO setRates(Map<String, BigDecimal> rates) {
      this.rates = rates;
      return this;
   }
}
