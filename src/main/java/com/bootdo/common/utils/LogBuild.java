package com.bootdo.common.utils;

/**
 * 日志格式化输出工具
 * @author lj
 */
public class LogBuild {
	/**“参数-值”分割符*/
	private static final String DEFAULT_PARAM_VALUE_SPLITTER = "=";
	/**“参数”分隔符*/
	private static final String DEFAULT_PARAM_SPLITTER = ", ";
	/**“日志分段”分隔符*/
	private static final String DEFAULT_LOG_SPLITTER = " - ";
	
	/**
	 * 获取日志构造器
	 * @author prwang
	 * @description 
	 * @param flag
	 * @param step
	 * @return
	 */
	public static Builder getBuilder(String flag, String step) {
		return new Builder(flag, step, null, null);
	}
	
	/**
	 * 获取日志构造器
	 * @author prwang
	 * @description 
	 * @param flag
	 * @param step
	 * @param key
	 * @param value
	 * @return
	 */
	public static Builder getBuilder(String flag, String step, String key, String value) {
		return new Builder(flag, step, key, value);
	}
	
	/**
	 * 日志构造器
	 * @author prwang
	 * @description 
	 */
	public static class Builder {
		/**日志标记*/
		private String flag;
		/**关键步骤*/
		private String step;
		/**搜索key*/
		private String key;
		/**搜索key值*/
		private String value;
		/**重要参数串*/
		private StringBuilder params;

		private String getFlag() {
			return flag;
		}
		private void setFlag(String flag) {
			this.flag = flag;
		}
		private String getStep() {
			return step;
		}
		private void setStep(String step) {
			this.step = step;
		}
		private String getKey() {
			return key;
		}
		private void setKey(String key) {
			this.key = key;
		}
		private String getValue() {
			return value;
		}
		private void setValue(String value) {
			this.value = value;
		}
		private StringBuilder getParams() {
			return params;
		}
		private void setParams(StringBuilder params) {
			this.params = params;
		}

		private Builder() {}
		
		public Builder(String flag, String step, String key, String value) {
			this.setFlag(flag);
			this.setStep(step);
			this.setKey(key);
			this.setValue(value);
			this.setParams(new StringBuilder());
		}
		
		public Builder flag(String flag) {
			this.setFlag(flag);
			return this;
		}
		
		public Builder step(String step) {
			this.setStep(step);
			return this;
		}
		
		public Builder kv(String key, String value) {
			this.setKey(key);
			this.setValue(value);
			return this;
		}
		
		public Builder kv(String key, Object value) {
			return kv(key, String.valueOf(value));
		}
		
		public Builder appendPV(String param, String value) {
			if(null == this.getParams()) {
				this.setParams(new StringBuilder());
			}
			if(0 < this.getParams().length()) {
				this.getParams().append(DEFAULT_PARAM_SPLITTER);
			}
			this.getParams().append(param).append(DEFAULT_PARAM_VALUE_SPLITTER).append(value);
			return this;
		}
		
		public Builder appendPV(String param, Object value) {
			return appendPV(param, String.valueOf(value));
		}
		
		public Builder appendPV(String param, boolean value) {
			return appendPV(param, String.valueOf(value));
		}
		
		public Builder appendPV(String param, int value) {
			return appendPV(param, String.valueOf(value));
		}
		
		public Builder appendPV(String param, Integer value) {
			return appendPV(param, String.valueOf(value));
		}
		
		public Builder appendPV(String param, long value) {
			return appendPV(param, String.valueOf(value));
		}
		
		public Builder appendPV(String param, Long value) {
			return appendPV(param, String.valueOf(value));
		}
		
		public Builder appendPV(String param, float value) {
			return appendPV(param, String.valueOf(value));
		}
		
		public Builder appendPV(String param, double value) {
			return appendPV(param, String.valueOf(value));
		}


	/*	public Builder appendPV(String param, Date date) {
			return appendPV(param, DateUtils.getTodayDayString(date));
		}
*/
		public String build() {
			return toString();
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder().append(this.getFlag())
					.append(DEFAULT_LOG_SPLITTER).append(this.getStep())
					.append(DEFAULT_LOG_SPLITTER).append(this.getKey()).append(DEFAULT_PARAM_VALUE_SPLITTER).append(this.getValue());
			if((null != this.getParams()) && (0 < this.getParams().length())) {
					sb.append(DEFAULT_PARAM_SPLITTER).append(this.getParams());
			}
			return sb.toString();
		}
	}
}
