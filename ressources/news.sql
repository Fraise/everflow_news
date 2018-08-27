-- MySQL dump 10.16  Distrib 10.1.35-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: everflow_news_db
-- ------------------------------------------------------
-- Server version	10.1.35-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `description` text,
  `url` varchar(255) NOT NULL,
  `publishedAt` bigint(20) NOT NULL,
  PRIMARY KEY (`news_id`),
  UNIQUE KEY `url` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'Public Bravado, Private Doubts: How Elon Musk\'s Tesla Plan Unraveled','','https://www.wsj.com/articles/public-bravado-private-doubts-how-elon-musks-tesla-plan-unraveled-1535326249',1535340820000),(2,'Dude Who Tried to Shake Down Mark Zuckerberg Caught in Ecuador After Three Years on the Run','','https://gizmodo.com/dude-who-tried-to-shake-down-mark-zuckerberg-caught-in-1828615201',1535339656000),(3,'To throttle or not? Readers say Verizon is entitled to make a buck','The throttling controversy shows no signs of slowing down. Verizon has apologized for slowing down a California fire department\'s wireless service after it used its monthly data allotment. After we said Verizon should just stop throttling altogether, some rea…','https://www.usatoday.com/story/tech/talkingtech/2018/08/26/verizon-entitled-throttle-make-buck/1105022002/',1535336400000),(4,'Social Security: How Working During Retirement Affects Your Benefits','You can still work after you claim Social Security, but it may affect how much you receive in benefits.','https://www.fool.com/retirement/2018/08/26/social-security-how-working-during-retirement-affe.aspx',1535335672000),(5,'The battle for cheap solar power heads to the sunny South — but utilities are fighting back','Solar panels could flood Alabama and other Southern states with cheap, clean power. What stands in the way?','https://www.salon.com/2018/08/26/the-fight-for-cheap-solar-is-going-south_partner/',1535321814000),(6,'Will Crude Break The Hearts Of The Bulls Or The Bears?','Brent oil and WTI crude oil futures tumbled to the predicted levels of the prior article. US sanctions against Iran are due on 5th November and testing traders\'','https://seekingalpha.com/article/4202128-will-crude-break-hearts-bulls-bears',1535321491000),(7,'2 million customers affected in T-Mobile data breach','T-Mobile is warning customers of a data breach that occurred last week.','https://www.abcactionnews.com/news/national/2-million-customers-affected-in-t-mobile-data-breach',1535313256000),(8,'Gala apple passes Red Delicious as America\'s favorite','The Red Delicious apple is expected to lose its title as the most popular apple this year, a perch it held for more than half a century.','https://www.usatoday.com/story/money/2018/08/26/red-delicious-apples-gala/1103768002/',1535311372000),(9,'Why companies are offering \'furternity\' leave to new pet owners','A Minneapolis-based marketing firm is one of many companies offering \"furternity\" leave for all new pet moms and dads. The policy is part of a growing trend in pet friendly workplace policies and a way to offer workers flexibility they might not have otherwis…','https://www.cnbc.com/2018/08/26/pawternity-pet-leave-is-a-new-perk-for-the-workplace.html',1535306542000),(10,'Powell, Trump and Amazon Effect: What We Heard at Jackson Hole','','https://www.bloomberg.com/news/articles/2018-08-26/powell-trump-and-amazon-effect-what-we-heard-at-jackson-hole',1535305059000),(11,'What Amazon Did This Week','WADTW is your weekly roundup that puts Amazon under the microscope - posted on sunday - bookmark the search \'WDADTW\' now','https://www.forbes.com/sites/paularmstrongtech/2018/08/26/what-amazon-did-this-week-2/',1535303525000),(12,'1962 Ferrari 250 GTO Smashes Auction Record, Selling For $48.4 Million','The auction of this rare specimen was the highlight at Monterey Car Week in Pebble Beach, fetching a record $48.4 million.','https://www.forbes.com/sites/rebeccalindland/2018/08/26/ferrari-250-gto-fetches-record-44-million-at-auction/',1535303525000),(13,'The Best Under-the-Radar Marijuana Stock I\'ve Seen So Far','This Canadian marijuana stock looks like one of the best ways to profit from growth in the U.S. cannabis industry.','https://www.fool.com/investing/2018/08/26/the-best-under-the-radar-marijuana-stock-ive-seen.aspx',1535303275000),(14,'Didi Suspends Carpooling Service in China After 2nd Passenger Is Killed','The Chinese ride-hailing giant, which also fired two executives, has been criticized for not addressing the safety concerns of women who use its services.','https://www.nytimes.com/2018/08/26/business/didi-chuxing-murder-rape-women.html',1535298222000),(15,'Andrew McCain, John McCain\'s Son: 5 Fast Facts You Need to Know','John McCain has 7 children. Get to know more about his family, focusing on his son Andrew.','https://heavy.com/news/2018/08/andrew-mccain-john-son-andy/',1535261172000),(16,'This little-talked about correlation suggests bitcoin may end year \'explosively higher\': Tom Lee','Fundstrat\'s Tom Lee sees a budding relationship between bitcoin and the emerging markets that could soon turn bullish.','https://www.cnbc.com/2018/08/25/this-correlation-suggests-bitcoin-may-end-year-explosively-higher.html',1535245669000),(17,'Walt Disney World Workers Reach Deal for $15 Minimum Wage by 2021','A group of six unions representing 38,000 Disney employees in Florida has reached an agreement with the company to raise the minimum starting wage.','https://www.nytimes.com/2018/08/25/business/disney-world-minimum-wage-union.html',1535244739000),(18,'Automakers are tapping nostalgia to promote electric cars — and it\'s working','Some of the flashiest cars at this year’s Pebble Beach Concours d’Elegance are reminders of the greatest hits in automotive history. They’re just the latest examples of how automakers are reaching into the past to promote the electric future.','https://www.theverge.com/2018/8/25/17779166/pebble-beach-mercedes-benz-eq-jaguar-infiniti',1535234416000),(19,'`Amazon Effect\' May Make Central Bank Job Harder: Jackson Hole','','https://www.bloomberg.com/news/articles/2018-08-25/-amazon-effect-may-challenge-economy-models-jackson-hole-paper',1535222196000),(20,'Steve Jobs\' Daughter Wrote a Shocking Childhood Memoir, But Doesn\'t Want You To Think Badly of Him','','https://uk.news.yahoo.com/steve-jobs-apos-daughter-wrote-220950030.html',1535162940000);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-26 21:38:12
