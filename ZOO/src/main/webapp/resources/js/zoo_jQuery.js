function connectSummonSNSControlAreaEvent() {
	// 만약 여기에 내가 따로 함수를 만들어 Height값을 계산하는 식으로 함수를 만들었다면.
	// 아래 Main에서의 불러오는 순서가 중요할것임
	// 하지만 내가 만든것에는 따로 Height값을 계산하는 식이 없기에
	// js가 작동하지 않는것은 없었음 그래도 나중에 만약에 내가 이 안에 무언가를 계산하는 함수를 만든다면
	// 생각해봐야할것 JavaScript는 오류 찾기가 정말 힘듬
	var visible = false;
	$("#snsControlAreaHandle").click(function() {
		if (visible) {
			$("#snsControlArea1").css("bottom", "-265px");

		} else {
			$("#snsControlArea1").css("bottom", "0px");
		}
		visible = !visible;

	});

}
function connectSummonSNSControlAreaEvent2() {
	var visible = false;
	$("#snsControlAreaHandle").click(function() {
		if (visible) {
			$("#snsControlArea3").css("bottom", "-100px");

		} else {
			$("#snsControlArea3").css("bottom", "0px");
		}
		visible = !visible;

	});

}

function misaemungi() {
	(function(w, d, t, f) {
		w[f] = w[f]
				|| function(c, k, n) {
					s = w[f], k = s['k'] = (s['k'] || (k ? ('&k=' + k) : ''));
					s['c'] = c = (c instanceof Array) ? c : [ c ];
					s['n'] = n = n || 0;
					L = d.createElement(t), e = d.getElementsByTagName(t)[0];
					L.async = 1;
					L.src = '//feed.aqicn.org/feed/' + (c[n].city) + '/'
							+ (c[n].lang || '') + '/feed.v1.js?n=' + n + k;
					e.parentNode.insertBefore(L, e);
				};
	})(window, document, 'script', '_aqiFeed');

}

function connectSummonSNSUpdateAreaEvent() {
	$("#x").click(function() {
		$("blackArea").css("opacity", 0);
		setTimeout(function() {
			$("#blackArea").css("left", "-100%");
			$("#balckArea").css("top", "-100%");
		}, 300);
	});
}

function connectMemberIDCheckEvent() {
    // 아이디 중복검사
    $("#memberJoinID").keyup(function(e) {
       // if (e.keyCode == 65) {
            var id = $(this).val();
            $.ajax({
                url: "member.get2",
                data: { zm_id: id }, // 오타 수정: 쉼표(,) 빠짐
                success: function(memberData) {
                    if (memberData.zoomember[0] == null) {
                        $("#memberJoinID").css("color", "white");
                    } else {
                        $("#memberJoinID").css("color", "red");
                    }
                }
            });
        //}
    });
}


function connectSummonJoinControlAddrSearchevent() {

	$("#addr1,#addr2").click(function() {
		new daum.Postcode({
			oncomplete : function(data) {
				// alert(data);
				// JS객체->글자
				// alert(JSON.stringify(data));
				$("#addr1").val(data.zonecode);
				$("#addr2").val(data.address);
			}
		}).open();

	});

}

function connectSummonTitleControlevent() {
	var t = $("#siteLoginArea").css("top");

	$("#siteTitleArea").mouseenter(function() {
		$("#siteTitleArea").css("top", "0px");

	});
	$("#siteTitleArea").mouseleave(function() {
		$("#siteTitleArea").css("top", "-50px");

	});

}

$(function() {
	 connectMemberIDCheckEvent();
	connectSummonSNSControlAreaEvent();
	connectSummonSNSControlAreaEvent2();
	connectSummonSNSUpdateAreaEvent();
	connectSummonJoinControlAddrSearchevent();
	connectSummonTitleControlevent();
});
