package net.sf.esfinge.comparison.reader;


public class MetadataReaderProvider {

	private static MetadataReaderProvider provider;
	
	public static MetadataReaderProvider getProvider(){
		if(provider == null){
			provider = new MetadataReaderProvider();
		}
		return provider;
	}
	
	private ComparisonMetadataReader reader;
	

	public void setReader(ComparisonMetadataReader reader){
		this.reader = reader;
	}
	public ComparisonMetadataReader getReader(){
		return reader;
	}
	
	//ease the access to configured reader
	public static void set(ComparisonMetadataReader reader){
		getProvider().setReader(reader);
	}
	public static ComparisonMetadataReader get(){
		return getProvider().getReader();
	}
}
