# 6주차 미니프로젝트

<h1>
ERD
</h1>



![2조 erd](https://user-images.githubusercontent.com/110470208/189051930-421375cf-4c65-4365-b49e-bb6f04da89d9.JPG)





# 회원가입 Api명세서

[로그인](https://www.notion.so/3270af0408bc4e72b8a521b7948b4476)

[파일 업로드](https://www.notion.so/434cc1525d094ee3b6e6393457cae330)

[게시글 작성](https://www.notion.so/762abbeae76249998b589f5da96c075b)

[특정 게시글 조회](https://www.notion.so/0115b870ca694b7e9d033d4331be3441)

[전체 게시글 조회](https://www.notion.so/db883d2c1db943d689a4f1529bf080d9)

[게시글 수정](https://www.notion.so/d67c38a4a7af450d83d2f190d7828634)

[게시글 삭제](https://www.notion.so/971420c6947c438ba1532448f22b1aef)

[댓글 작성 ](https://www.notion.so/dc45ef8e700b4efeae0d9c6489488523)

[댓글 수정](https://www.notion.so/be88a9c96fc94e76a9be999585812e40)

[댓글 삭제](https://www.notion.so/455263b828e54bfd8a83a92a558ec329)

[게시글 좋아요/삭제](https://www.notion.so/83c909d4823140fa8e1ab8d6952f142d)

[마이페이지](https://www.notion.so/0c9a7e5a9f664aeabcb3ca3784d22183)

[스케쥴러](https://www.notion.so/a3d8d9e9478e48e8a4a2413097800a24)

===========================================================================
<br>
<h1>Trouble Shooting</h1>

<h3>1</h3><br>
회원가입은 되는데 로그인 실패. SQL error 500 메시지 나옴.<br> 
기존 아이디는 로그인이 가능했었음<br>
postman으로 새로운 아이디 생성 후 로그인시도 콘솔에 nullpointerexception이 터져서 확인,<br> 
refresh토큰 테이블에 잘못된 entity속성이 들어갔음.<br>
db초기화 후 로그인 성공함
<h3>2</h3><br>
헤더에 토큰이 요청되지 않는 사항 발생 -> Service에 Refresh-Token을 헤더에 보내는 과정에서 Refresh-Token에 대한 명칭 통일(refreshtoken)


