package com.ebay.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.ebay.fsm.cilog.CIBuild;

public class ImageUtils {
	public static String getSimplePluginName(String pluginName) {
		return pluginName.replace("org.apache.maven.plugins:", "").replace("com.ebay.raptor.build:", "").replace("org.codehaus.mojo:", "");
	}
	public static void createChart(List<CIBuild> ciBuildData) {
		CategoryDataset dataset = perfDataoDataset(ciBuildData);
		JFreeChart chart = createChart(dataset);
		BufferedImage image = chart.createBufferedImage(1024, 768);
		File outputfile = new File("C:\\Users\\jyang12\\Desktop\\trash\\images\\" + System.currentTimeMillis() + ".png");
		try {
			ImageIO.write( image, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static CategoryDataset perfDataoDataset(List<CIBuild> ciBuildData) {
//		int row = ciBuildData.get(0).getPluginNum();
//		int col = ciBuildData.size();
		
		int colIndex = 0;
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		for (CIBuild ciBuild : ciBuildData) {
			List<String> pluginNames = ciBuild.getOrderedPluginNames();
			  
			
			for (String pluginName : pluginNames) {
				dataSet.addValue(ciBuild.getPerfData(pluginName), getSimplePluginName(pluginName), "build" + colIndex);
//				data[rowIndex][colIndex] = ciBuild.getPerfData(pluginName);
			}
			colIndex++;
		}
//
//		final CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
//				"Plugin ", "Build ", data);
		return dataSet;
	}

	public static JFreeChart createChart(CategoryDataset dataset) {
		final JFreeChart chart = ChartFactory.createStackedAreaChart(
				"CI build of Raptor SRP Project", // chart title
				"Build", // domain axis label
				"Time Costed(ms)", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, false);

		chart.setBackgroundPaint(Color.white);

		final CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setForegroundAlpha(0.5f);
		plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		

		final CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setLowerMargin(0.0);
		domainAxis.setUpperMargin(0.0);

		// change the auto tick unit selection to integer units only...
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		final CategoryItemRenderer renderer = plot.getRenderer();
		renderer.setItemLabelsVisible(true);
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesPaint(1, Color.GREEN);//бли╚
		renderer.setSeriesPaint(2, Color.BLACK);
		renderer.setSeriesPaint(3, Color.BLUE);
		renderer.setSeriesPaint(4, Color.CYAN);
		renderer.setSeriesPaint(5, Color.DARK_GRAY);
		renderer.setSeriesPaint(6, Color.GRAY);
		renderer.setSeriesPaint(7, Color.LIGHT_GRAY);
		renderer.setSeriesPaint(8, Color.MAGENTA);
		renderer.setSeriesPaint(9, Color.ORANGE);
		renderer.setSeriesPaint(10, Color.PINK);
		renderer.setSeriesPaint(11, Color.WHITE);
		renderer.setSeriesPaint(23, Color.YELLOW);
		return chart;

	}
}
