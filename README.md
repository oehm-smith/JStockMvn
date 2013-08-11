JStockMvn
=========

A copy of the excellent JStock ported to Eclipse instead of Netbeans and Maven instead of bundled jars.  Excepting for a couple jars that either didn't exist in any public maven repository or existed in a maven repository but not at the same version used.

The original JStock is at [http://jstock.sourceforge.net/](http://jstock.sourceforge.net/).

Another reason for creating this is for my new project [StockRS](https://github.com/oehm-smith/StockRS), which is purely a stock portfolio management service with a RESTful web services interface.  It will be based on JStock.

# Configuration
* None at this stage excepting what is required by JStock

# Running
## Eclipse (development)
* Run-As > Java Application and choose `org.yccheok.jstock.gui.MainFrame` as the main class (if this Run Configuration doesn't already exist).

## Command-Line
	mvn package
	java -jar target/jstock.jar

