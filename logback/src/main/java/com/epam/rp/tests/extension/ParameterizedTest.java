package com.epam.rp.tests.extension;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * Extension example
 *
 * @author Andrei Varabyeu
 */
//@Listeners({ ParameterizedTest.ExtendedListener.class })
public class ParameterizedTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParameterizedTest.class);

	@Test(threadPoolSize = 2, dataProvider = "bla-bla")
	public void testParams(String msg) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			LOGGER.info(msg + ": " + i);
			if (i == 1) {
				Thread.sleep(TimeUnit.SECONDS.toMillis(5L));
			}
		}
	}

	@DataProvider(parallel = true, name = "bla-bla")
	public Iterator<Object[]> params() {
		return Arrays.asList(new Object[] { "one" }, new Object[] { "two" }).iterator();
	}

//	public static class ExtendedListener extends BaseTestNGListener {
//		public ExtendedListener() {
//			super(new ParamTaggingTestNgService());
//		}
//
//		@Override
//		public void onTestStart(ITestResult testResult) {
//			System.out.println(testResult.getMethod().getInvocationCount());
//
//			System.out.println(testResult.getMethod().getCurrentInvocationCount());
//			super.onTestStart(testResult);
//		}
//	}
//
//	public static class ParamTaggingTestNgService extends TestNGService {
//
//		@Override
//		protected StartTestItemRQ buildStartStepRq(ITestResult testResult) {
//			final StartTestItemRQ rq = super.buildStartStepRq(testResult);
//			if (testResult.getParameters() != null && testResult.getParameters().length != 0) {
//				final Set<String> tags = Optional.fromNullable(rq.getTags()).or(new HashSet<>());
//				for (Object param : testResult.getParameters()) {
//					tags.add(param.toString());
//				}
//				rq.setTags(tags);
//
//			}
//			return rq;
//		}
//	}

}
