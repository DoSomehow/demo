package org.ms.javaTest.servlet;

import org.ms.javaTest.util.Base64;
import org.ms.javaTest.util.FileUtil;
import org.ms.javaTest.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class UploadFileServlet extends HttpServlet {

    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    private static final String NAME = "name";
    private static final String FILE_NAME = "filename";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String BASE_FILE_PATH = "D:\\tmp\\upload\\";

    private int boundaryLength = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        // String username = request.getParameter("username");
        // System.out.println("username: " + username);

        try {
            BufferedInputStream isr = new BufferedInputStream(request.getInputStream());
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int rc = 0;
            while ((rc = isr.read(buff)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            byte[] in2b = swapStream.toByteArray();

            // System.out.println("----------- 我是分割线 -------------");
            // System.out.println(request.getContentType());
            // System.out.println("----------- 我是分割线 -------------");
            // System.out.println(new String(in2b, "utf-8"));

            // InputStream input = new ByteArrayInputStream(in2b);
            // byte[] fileByteArr = getImgData(in2b, request.getContentType());
            // FileUtil.byte2File(fileByteArr, BASE_FILE_PATH, "touxiang.jpg");

            // System.out.println("request: " + in2b.length);
            String encodeBufferOut = Base64.encode(in2b);
            dataHandle(encodeBufferOut, request.getContentType());

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * 取得图片数据
     *
     * @param requestData
     * @param contentType
     * @return
     * @throws IOException
     */
    // private byte[] getImgData(byte[] requestData, String contentType)
    //         throws IOException {
    //     String txtBody = new String(requestData, "GBK");
    //     if (!txtBody.contains("image/jpg") && !txtBody.contains("image/jpeg")&& !txtBody.contains("jpg")) {
    //         return null;
    //     }
    //     String boundary = contentType.substring(contentType.lastIndexOf("=") + 1, contentType.length());
    //     // 取得实际上传文件的起始与结束位置
    //     int pos = txtBody.indexOf("filename=\"");
    //     pos = txtBody.indexOf("\n", pos) + 1;
    //     pos = txtBody.indexOf("\n", pos) + 1;
    //     pos = txtBody.indexOf("\n", pos) + 1;
    //     // 文件描述信息后就文件内容，直到为文件边界为止，从pos开始找边界
    //     int boundaryLoc = txtBody.indexOf(boundary, pos) - 4;
    //     txtBody.indexOf("boundaryLoc: " + boundaryLoc);
    //     ByteArrayOutputStream realDatas = null;
    //     try {
    //         int begin = ((txtBody.substring(0, pos)).getBytes("GBK")).length;
    //         int end = ((txtBody.substring(begin, boundaryLoc)).getBytes("GBK")).length;
    //         realDatas = new ByteArrayOutputStream();
    //         realDatas.write(requestData, begin, end);
    //         return realDatas.toByteArray();
    //     } finally {
    //         if (null != realDatas) {
    //             try {
    //                 realDatas.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    // }

    private byte[] getImgData(byte[] requestData, String contentType)
            throws IOException {
        // String txtBody = new String(requestData, "GBK");
        String txtBody = new String(requestData);
        if (!txtBody.contains("image/jpg") && !txtBody.contains("image/jpeg")&& !txtBody.contains("jpg")) {
            return null;
        }
        String boundary = contentType.substring(contentType.lastIndexOf("=") + 1, contentType.length());
        // 取得实际上传文件的起始与结束位置
        int pos = txtBody.indexOf("filename=\"");
        pos = txtBody.indexOf("\n", pos) + 1;
        pos = txtBody.indexOf("\n", pos) + 1;
        pos = txtBody.indexOf("\n", pos) + 1;
        // 文件描述信息后就文件内容，直到为文件边界为止，从pos开始找边界
        int boundaryLoc = txtBody.indexOf(boundary, pos) - 2;  //不减4，减2也可以啊
        txtBody.indexOf("boundaryLoc: " + boundaryLoc);

        ByteArrayOutputStream realDatas = null;
        try {
            int begin = ((txtBody.substring(0, pos)).getBytes("GBK")).length;
            int end = ((txtBody.substring(begin, boundaryLoc)).getBytes("GBK")).length;
            System.out.println("begin: " + begin);
            System.out.println("len: " + end);
            realDatas = new ByteArrayOutputStream();
            realDatas.write(requestData, begin, end);

            // byte[] destArr = new byte[102400];
            // System.arraycopy(requestData, begin, destArr, end, (end - begin + 1));
            // System.out.println(new String(destArr));
            // System.out.println(Arrays.toString(destArr));

            return realDatas.toByteArray();
        } finally {
            if (null != realDatas) {
                try {
                    realDatas.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void dataHandle(String bufferOut, String requestContentType){
        byte[] in2b = Base64.decode(bufferOut);
        // System.out.println("after transform: " + in2b.length);
        // try {
        //     // byte[] in2b = bufferOut.getBytes("GBK");
        //     byte[] fileByteArr = getImgData(in2b, requestContentType);
        //     FileUtil.byte2File(fileByteArr, BASE_FILE_PATH, "touxiang.jpg");
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        try {
            bufferOut = new String(in2b, "GBK");
            // System.out.println(bufferOut);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //先简单判断下  //之后还有录音   //这种方式判断不一定行，body中可能会包含这种文本
        // if (!bufferOut.contains("image/jpg") && !bufferOut.contains("image/jpeg")
        //         && !bufferOut.contains("image/pjpeg") && !bufferOut.contains("jpg")) {
        //     return;
        // }

        //获得边界
        String boundary = requestContentType.substring(requestContentType.lastIndexOf("=") + 1, requestContentType.length());
        try {
            boundaryLength = boundary.getBytes("GBK").length;
        } catch (Exception e) {
            e.printStackTrace();
        }

        //先按边界进行下拆分
        String[] dataArr = bufferOut.split(boundary);
        int index = 0;
        try {
            index = dataArr[0].getBytes("GBK").length + boundaryLength;
            // System.out.println("dataArr 1: " + dataArr[0]);
            // System.out.println("boundary content: " + boundary);
            // System.out.println("first index: " + index);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for(int i = 1; i < dataArr.length-1; i++){  //由于第一个boundary前边和最后一个boundary后边都有 --，所以i的取值除头去尾
            String fileData = dataArr[i];

            // System.out.println("============================================ "+i+" ===============================================");
            // System.out.println(fileData);
            // System.out.println("============================================ "+i+" ===============================================");

            Map<String, String> headerMap = getHeaderMap(fileData);
            String fileName = headerMap.get(FILE_NAME);
            if(StringUtil.isEmpty(fileName)){
                try {
                    index += fileData.getBytes("GBK").length + boundaryLength;  //加2是结尾 -- 的长度  //不能加2，因为用boundary拆分时，fileData中已经包含了 --
                    // System.out.println("fileData length: " + fileData.getBytes("GBK").length);
                    // System.out.println("boundary: " + boundaryLength);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                continue;
            }

            String contentType = headerMap.get(CONTENT_TYPE);
            if(isPhoto(contentType)){
                createFile(fileData, fileName, in2b, index);
            }else if (isRecording(contentType)){
                //TODO: 录音文件怎么弄？

            }else{

            }
            try {
                index += fileData.getBytes("GBK").length + boundaryLength;  //加2是结尾 -- 的长度  //不能加2，因为用boundary拆分时，fileData中已经包含了 --
                // System.out.println("fileData length: " + fileData.getBytes("GBK").length);
                // System.out.println("boundary: " + boundaryLength);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

    }

    private void createFile(String fileData, String fileName, byte[] in2b, int index){
        int pos = fileData.indexOf("\r\n", 2) + 2;  //由于split时，带的有 \r\n 所以从2开始
        pos = fileData.indexOf("\r\n", pos) + 2;
        pos = fileData.indexOf("\r\n", pos) + 2;

        int boundaryLoc = fileData.lastIndexOf("--")-4;  //除了减去 -- 的长度，是不是还因为 \r\n 而减去2 ？   //不对，我这个fileData是不包含boundary的，所以不需要最后再减
        // System.out.println(fileData);

        ByteArrayOutputStream realDatas = null;
        try {
            int begin = ((fileData.substring(0, pos)).getBytes("GBK")).length;  //注意这里要从0开始，因为要去掉body所有字符
            int len = ((fileData.substring(begin, boundaryLoc)).getBytes("GBK")).length;
            int indexInByteArr = begin + index;

            // System.out.println("=======================================================================================================");
            // System.out.println(fileData.substring(begin, boundaryLoc));
            // System.out.println("=======================================================================================================");

            // System.out.println("begin: " + begin);
            // System.out.println("body length: " + len);
            // System.out.println("body end: " + (fileData.substring(boundaryLoc)).getBytes("GBK").length);
            // System.out.println("body end content: " + fileData.substring(boundaryLoc));
            // System.out.println("para index: " + index);
            // System.out.println("byte index: " + indexInByteArr);
            // System.out.println(fileData.substring(0, pos));
            // System.out.println(fileData.substring(begin, boundaryLoc));
            realDatas = new ByteArrayOutputStream();
            // realDatas.write(fileData.getBytes("GBK"), begin, end);
            // realDatas.write(in2b, begin, len);
            realDatas.write(in2b, indexInByteArr, len);

            // byte[] destArr = new byte[102400];
            // System.arraycopy(in2b, indexInByteArr, destArr, 0, len);
            // // System.out.println(new String(destArr));
            // System.out.println(Arrays.toString(destArr));
            // System.out.println("=======================================================================================================");
            // System.out.println(new String(destArr, "GBK"));
            // System.out.println("=======================================================================================================");

            byte[] byteData = realDatas.toByteArray();
            FileUtil.byte2File(byteData, BASE_FILE_PATH, fileName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            if (null != realDatas) {
                try {
                    realDatas.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // private void createFile(String fileData, String fileName){
    //     int pos = fileData.indexOf("\n") + 1;
    //     pos = fileData.indexOf("\n", pos) + 1;
    //     pos = fileData.indexOf("\n", pos) + 1;
    //
    //     int boundaryLoc = fileData.lastIndexOf("--");
    //
    //     String body = fileData.substring(pos, boundaryLoc);
    //     byte[] byteData = new byte[0];  //是否指定编码格式？
    //     try {
    //         byteData = body.getBytes("GBK");
    //     } catch (UnsupportedEncodingException e) {
    //         e.printStackTrace();
    //     }
    //     FileUtil.byte2File(byteData, BASE_FILE_PATH, fileName);
    //
    // }

    private Map<String, String> getHeaderMap(String data){
        Map<String, String> headerMap = new HashMap<>();

        //第一行
        int index = data.indexOf("\r\n") + 2;  //好像是\r\n时，算两个，要加2
        int row_end_one = data.indexOf("\r\n", index);
        String row_data_one = data.substring(index, row_end_one);
        parseHeaderRowData(row_data_one, headerMap);

        //第二行
        int row_end_two = data.indexOf("\r\n", row_end_one + 2);  //这里和下一行截取时，也是要加2
        String row_data_two = data.substring(row_end_one + 2, row_end_two);  //有可能为空，比如普通的输入框上传的参数
        if(row_data_two != null && !"".equals(row_data_two)){
            parseHeaderRowData(row_data_two, headerMap);
        }
        return headerMap;
    }

    private void parseHeaderRowData(String rowData, Map<String, String> headerMap){
        String[] rowDataArr = rowData.split(";");  //用分号分隔
        for(String metaData : rowDataArr){
            if(metaData.contains(":")){  //用冒号分隔
                String[] metaArr = metaData.split(":");
                headerMap.put(metaArr[0].trim(), metaArr[1].trim());

            }else if(metaData.contains("=")){  //用等号分隔
                String[] metaArr = metaData.split("=");
                String value = metaArr[1].substring(1, metaArr[1].length() - 1).trim();
                headerMap.put(metaArr[0].trim(), value);
            }
        }
    }

    private boolean isPhoto(String contentType){
        if(contentType.equals("image/jpg")
                || contentType.equals("image/jpeg")
                || contentType.equals("image/pjpeg")
                || contentType.equals("jpg")){
            return true;
        }
        return false;
    }

    private boolean isRecording(String contentType){
        if(contentType.equals("")){
            return true;
        }
        return false;
    }


}
