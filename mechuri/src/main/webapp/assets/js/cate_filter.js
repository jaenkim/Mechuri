$(document).ready(function() {
    //Main 카테고리 셋팅 (DB에서 값을 가져와 셋팅 하세요.)
    var filter_catelnameArray = new Array();
    var filter_catelnameObject = new Object();
     
    filter_catelnameObject = new Object();
    filter_catelnameObject.main_category_id = "기초";
    filter_catelnameObject.main_category_name = "기초";
    filter_catelnameArray.push(filter_catelnameObject);
     
    filter_catelnameObject = new Object();
    filter_catelnameObject.main_category_id = "베이스";
    filter_catelnameObject.main_category_name = "베이스";
    filter_catelnameArray.push(filter_catelnameObject);
    
    filter_catelnameObject = new Object();
    filter_catelnameObject.main_category_id = "클렌징";
    filter_catelnameObject.main_category_name = "클렌징";
    filter_catelnameArray.push(filter_catelnameObject);
    
    filter_catelnameObject = new Object();
    filter_catelnameObject.main_category_id = "색조";
    filter_catelnameObject.main_category_name = "색조";
    filter_catelnameArray.push(filter_catelnameObject);
    
    filter_catelnameObject = new Object();
    filter_catelnameObject.main_category_id = "선케어";
    filter_catelnameObject.main_category_name = "선케어";
    filter_catelnameArray.push(filter_catelnameObject);
    
    filter_catelnameObject = new Object();
    filter_catelnameObject.main_category_id = "바디/핸드/풋";
    filter_catelnameObject.main_category_name = "바디/핸드/풋";
    filter_catelnameArray.push(filter_catelnameObject);
    
    filter_catelnameObject = new Object();
    filter_catelnameObject.main_category_id = "베이비/맘";
    filter_catelnameObject.main_category_name = "베이비/맘";
    filter_catelnameArray.push(filter_catelnameObject);
    
    filter_catelnameObject = new Object();
    filter_catelnameObject.main_category_id = "남성";
    filter_catelnameObject.main_category_name = "남성";
    filter_catelnameArray.push(filter_catelnameObject);
     
    //Sub 카테고리 셋팅 (DB에서 값을 가져와 셋팅 하세요.)
    var filter_catesnameArray = new Array();
    var filter_catesnameObject = new Object();
     
    //기초에 해당하는 sub category 리스트
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "기초";
    filter_catesnameObject.sub_category_id = "스킨"
    filter_catesnameObject.sub_category_name = "스킨" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "기초";
    filter_catesnameObject.sub_category_id = "로션"
    filter_catesnameObject.sub_category_name = "로션" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "기초";
    filter_catesnameObject.sub_category_id = "에센스"
    filter_catesnameObject.sub_category_name = "에센스" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "기초";
    filter_catesnameObject.sub_category_id = "크림"
    filter_catesnameObject.sub_category_name = "크림" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "기초";
    filter_catesnameObject.sub_category_id = "오일"
    filter_catesnameObject.sub_category_name = "오일" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "기초";
    filter_catesnameObject.sub_category_id = "팩"
    filter_catesnameObject.sub_category_name = "팩" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    //베이스에 해당하는 sub category 리스트
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "베이스";
    filter_catesnameObject.sub_category_id = "베이스"
    filter_catesnameObject.sub_category_name = "베이스" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "베이스";
    filter_catesnameObject.sub_category_id = "파운데이션"
    filter_catesnameObject.sub_category_name = "파운데이션"
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "베이스";
    filter_catesnameObject.sub_category_id = "비비"
    filter_catesnameObject.sub_category_name = "비비"
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "베이스";
    filter_catesnameObject.sub_category_id = "컨실러"
    filter_catesnameObject.sub_category_name = "컨실러"
    filter_catesnameArray.push(filter_catesnameObject);
    
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "베이스";
    filter_catesnameObject.sub_category_id = "파우더"
    filter_catesnameObject.sub_category_name = "파우더"
    filter_catesnameArray.push(filter_catesnameObject);
    
    //클렌징에 해당하는 sub category 리스트
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "클렌징";
    filter_catesnameObject.sub_category_id = "클렌징폼"
    filter_catesnameObject.sub_category_name = "클렌징폼" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "클렌징";
    filter_catesnameObject.sub_category_id = "클렌징오일"
    filter_catesnameObject.sub_category_name = "클렌징오일" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "클렌징";
    filter_catesnameObject.sub_category_id = "클렌징워터"
    filter_catesnameObject.sub_category_name = "클렌징워터" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "클렌징";
    filter_catesnameObject.sub_category_id = "클렌징티슈"
    filter_catesnameObject.sub_category_name = "클렌징티슈" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "클렌징";
    filter_catesnameObject.sub_category_id = "립앤아이리무버"
    filter_catesnameObject.sub_category_name = "립앤아이리무버" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "클렌징";
    filter_catesnameObject.sub_category_id = "스크럽/필링"
    filter_catesnameObject.sub_category_name = "스크럽/필링" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    //색조에 해당하는 sub category 리스트
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "색조";
    filter_catesnameObject.sub_category_id = "립스틱/립틴트"
    filter_catesnameObject.sub_category_name = "립스틱/립틴트" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "색조";
    filter_catesnameObject.sub_category_id = "립밤"
    filter_catesnameObject.sub_category_name = "립밤" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "색조";
    filter_catesnameObject.sub_category_id = "아이라이너"
    filter_catesnameObject.sub_category_name = "아이라이너" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "색조";
    filter_catesnameObject.sub_category_id = "마스카라"
    filter_catesnameObject.sub_category_name = "마스카라" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "색조";
    filter_catesnameObject.sub_category_id = "섀도우"
    filter_catesnameObject.sub_category_name = "섀도우" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "색조";
    filter_catesnameObject.sub_category_id = "블러셔/쉐딩"
    filter_catesnameObject.sub_category_name = "블러셔/쉐딩" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    //선케어에 해당하는 sub category 리스트
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "선케어";
    filter_catesnameObject.sub_category_id = "선크림"
    filter_catesnameObject.sub_category_name = "선크림" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "선케어";
    filter_catesnameObject.sub_category_id = "선스틱"
    filter_catesnameObject.sub_category_name = "선스틱" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "선케어";
    filter_catesnameObject.sub_category_id = "선스프레이"
    filter_catesnameObject.sub_category_name = "선스프레이" 
    filter_catesnameArray.push(filter_catesnameObject);
         
    //바디/핸드/풋에 해당하는 sub category 리스트
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "바디/핸드/풋";
    filter_catesnameObject.sub_category_id = "바디워시"
    filter_catesnameObject.sub_category_name = "바디워시" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "바디/핸드/풋";
    filter_catesnameObject.sub_category_id = "바디스크럽"
    filter_catesnameObject.sub_category_name = "바디스크럽" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "바디/핸드/풋";
    filter_catesnameObject.sub_category_id = "바디오일"
    filter_catesnameObject.sub_category_name = "바디오일" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "바디/핸드/풋";
    filter_catesnameObject.sub_category_id = "바디로션"
    filter_catesnameObject.sub_category_name = "바디로션" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "바디/핸드/풋";
    filter_catesnameObject.sub_category_id = "핸드크림"
    filter_catesnameObject.sub_category_name = "핸드크림" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "바디/핸드/풋";
    filter_catesnameObject.sub_category_id = "풋크림"
    filter_catesnameObject.sub_category_name = "풋크림" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    //베이비/맘에 해당하는 sub category 리스트
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "베이비/맘";
    filter_catesnameObject.sub_category_id = "베이비보습"
    filter_catesnameObject.sub_category_name = "베이비보습" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "베이비/맘";
    filter_catesnameObject.sub_category_id = "베이비샴푸"
    filter_catesnameObject.sub_category_name = "베이비샴푸" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "베이비/맘";
    filter_catesnameObject.sub_category_id = "베이비썬"
    filter_catesnameObject.sub_category_name = "베이비썬" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "베이비/맘";
    filter_catesnameObject.sub_category_id = "맘케어"
    filter_catesnameObject.sub_category_name = "맘케어" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "베이비/맘";
    filter_catesnameObject.sub_category_id = "물티슈"
    filter_catesnameObject.sub_category_name = "물티슈" 
    filter_catesnameArray.push(filter_catesnameObject);
    
    //남성에 해당하는 sub category 리스트
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "남성";
    filter_catesnameObject.sub_category_id = "스킨케어"
    filter_catesnameObject.sub_category_name = "스킨케어" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "남성";
    filter_catesnameObject.sub_category_id = "메이크업"
    filter_catesnameObject.sub_category_name = "메이크업" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "남성";
    filter_catesnameObject.sub_category_id = "바디"
    filter_catesnameObject.sub_category_name = "바디" 
    filter_catesnameArray.push(filter_catesnameObject);
     
    filter_catesnameObject = new Object();
    filter_catesnameObject.main_category_id = "남성";
    filter_catesnameObject.sub_category_id = "헤어"
    filter_catesnameObject.sub_category_name = "헤어" 
    filter_catesnameArray.push(filter_catesnameObject);
    //****************이부분은 DB로 셋팅하세요.
     
     
    //메인 카테고리 셋팅
    var filter_catelnameSelectBox = $("select[name='filter_catelname']");
     
    for(var i=0;i<filter_catelnameArray.length;i++){
        filter_catelnameSelectBox.append("<option value='"+filter_catelnameArray[i].main_category_id+"'>"+filter_catelnameArray[i].main_category_name+"</option>");
    }
     
    //*********** 1depth카테고리 선택 후 2depth 생성 START ***********
    $(document).on("change","select[name='filter_catelname']",function(){
         
        //두번째 셀렉트 박스를 삭제 시킨다.
        var filter_catesnameSelectBox = $("select[name='filter_catesname']");
        filter_catesnameSelectBox.children().remove(); //기존 리스트 삭제
         
        //선택한 첫번째 박스의 값을 가져와 일치하는 값을 두번째 셀렉트 박스에 넣는다.
        $("option:selected", this).each(function(){
            var selectValue = $(this).val(); //main category 에서 선택한 값
            filter_catesnameSelectBox.append("<option value=''>전체</option>");
            for(var i=0;i<filter_catesnameArray.length;i++){
                if(selectValue == filter_catesnameArray[i].main_category_id){
                     
                    filter_catesnameSelectBox.append("<option value='"+filter_catesnameArray[i].sub_category_id+"'>"+filter_catesnameArray[i].sub_category_name+"</option>");
                }
            }
        });
         
    });
    //*********** 1depth카테고리 선택 후 2depth 생성 END ***********
         
});