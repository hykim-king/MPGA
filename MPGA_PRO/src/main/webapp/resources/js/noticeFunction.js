/**
 * 
 */
 <script>

        function clickDel(noticeInfo) {
        noticeInfo.action = "/noticeDelete.do?seq=${noticeVO.seq}";
        noticeInfo.method = "post";
        noticeInfo.submit();
        }
 </script> 