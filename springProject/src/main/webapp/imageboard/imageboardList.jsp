<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/board.css">

<form name="imageboardListForm" id="imageboardListForm" method="post" action="/springProject/imageboard/imageboardDelete">
	<table id="imageboardTable" border="1" frame="hsides" rules="rows"
		cellspacing="0" cellpadding="5" style="word-break: break-all;">
		<tr>
			<th width="100"><input type="checkbox" id="all" />번호</th>
			<th width="120">이미지</th>
			<th width="200">상품명</th>
			<th width="100">단가</th>
			<th width="100">개수</th>
			<th width="100">합계</th>
		</tr>
	</table>
	<br>
	<div style="float: left; width: 80px;">
		<input type="button" id="choiceDeleteBtn" value="선택삭제">
	</div>
	<div id="imageboardPagingDiv" style="float: left; width: 650px; text-align: center;"></div>
</form>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		type: "post",
		url: "/springProject/imageboard/getImageboardList",
		data: "pg=${pg}",
		dataType: "json",
		success: function(data){
			//alert(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				$("<tr/>").append($("<td/>",{
					align: "center",
					text: items.seq
					}).prepend($("<input/>",{
						type: "checkbox",
						value: items.seq,
						name: "check",
						class: "check"
				}))).append($("<td/>",{
					align: "center",
					}).append($("<img/>",{
						src: "../storage/"+items.image1,
						style: "cursor: pointer; width: 70px; height: 70px;",
						class: items.seq
				}))).append($("<td/>",{
					align: "center",
					text: items.imageName
				})).append($("<td/>",{
					align: "center",
					text: items.imagePrice.toLocaleString()
				})).append($("<td/>",{
					align: "center",
					text: items.imageQty
				})).append($("<td/>",{
					align: "center",
					text: (items.imagePrice*items.imageQty).toLocaleString()
				})).appendTo($("#imageboardTable"));
				
				// 이미지 보기
				$("."+items.seq).click(function(){
					location.href="/springProject/imageboard/imageboardView?seq="+items.seq+"&pg=${pg}";     
				}); 
				
			});
				// 페이징처리
				$("#imageboardPagingDiv").html(data.imageboardPaging.pagingHTML);
		},
		error: function(err){
			console.log(err);
		}
	});
	
	// 전체 선택/해제
	$("#all").click(function(){
		if($("#all").prop("checked"))
			$(".check").prop("checked", true);
		else
			$(".check").prop("checked", false);
	});
	
	// 선택 삭제
	$("#choiceDeleteBtn").click(function(){
		var count = $(".check:checked").length;
		if(count == 0) {
			alert("삭제할 항목을 선택하세요!");
		} else {
			if(confirm("정말 삭제하시겠습니까?")) {
				$("#imageboardListForm").submit();
			}
		}
	});
});
</script>