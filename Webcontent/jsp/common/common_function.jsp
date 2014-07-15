<%!
String fileType[][] = {
        {".doc", "./image/fileicons/doc.gif"},
        {".docx", "./image/fileicons/doc.gif"},
        {".xls", "./image/fileicons/xls.gif"},
        {".xlsx", "./image/fileicons/xls.gif"},
        {".csv", "./image/fileicons/csv.gif"},
        {".ppt", "./image/fileicons/ppt.gif"},
        {".pptx", "./image/fileicons/ppt.gif"},
        {".pps", "./image/fileicons/pps.gif"},
        {".ppsx", "./image/fileicons/pps.gif"},
        {".pdf", "./image/fileicons/pdf.gif"},
        {".txt", "./image/fileicons/txt.gif"},
        {".jpeg", "./image/fileicons/jpg.gif"},
        {".jpg", "./image/fileicons/jpg.gif"},
        {".png", "./image/fileicons/png.gif"},
        {".rar", "./image/fileicons/zip.gif"},
        {".zip", "./image/fileicons/zip.gif"},
};

public String getIcon(String fileName) {
    fileName = fileName.toLowerCase();
    for (int i=0; i<fileType.length; i++)
    {
      if(fileName.endsWith(fileType[i][0])){
            return fileType[i][1];
      }
    }
    return "./image/fileicons/unknown.gif";
}
%>