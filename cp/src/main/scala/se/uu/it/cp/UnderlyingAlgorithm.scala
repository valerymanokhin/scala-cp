package se.uu.it.cp

/**
 * Defines an underlying algorithm to be used when training a conformal predictor.
 *
 *  @constructor it trains a new underlying algorithm
 *  @param properTrainingSet a training set that should be independent from the calibration set
 */
abstract class UnderlyingAlgorithm[DataPoint <: Any]() extends Serializable {
  
  /**
   * Given a feature sequence and a label it makes a DataPoint.
   * 
   * @param features data point feature sequence
   * @param label data point label
   * @return DataPoint with given feature sequence and label
   */
  def makeDataPoint(features: Seq[Double], label: Double): DataPoint
  
  /**
   * Given a DataPoint returns its feature sequence.
   * 
   * @param dataPoint a data point
   * @return data point feature sequence
   */
  def getDataPointFeatures(dataPoint: DataPoint): Seq[Double]
  
  /**
   * Given a DataPoint returns its feature sequence.
   * 
   * @param dataPoint a data point
   * @return data point label
   */
  def getDataPointLabel(dataPoint: DataPoint): Double
  
  /**
   * Given an unseen sample it returns a nonconformity score.
   *
   *  @param newSample an unseen sample
   *  @return nonconformity score for newSample
   */
  def nonConformityMeasure(newSample: DataPoint): Double
  
}