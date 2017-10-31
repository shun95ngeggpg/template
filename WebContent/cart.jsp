<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>カート</title>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<h1>カート</h1>
		</div>
		<div>
			<s:if test="myPageList == null">
				<h3>カートに商品はありません。</h3>
			</s:if>

			<table class="cartlist">

				<thead>
					<tr>
						<th class="img">商品画像</th>
						<th>商品名</th>
						<th class="okisa">価格</th>
						<th class="okisa">数量</th>
						<th class="okisa">小計</th>
						<th class="okisa">削除</th>
					</tr>
				</thead>

				<tbody>

					<s:iterator value="cartList">

						<tr>
							<td class="img2"><img src="<s:property value="img" />"
								alt="" width="130" height="100"></td>
							<td><s:property value="itemName" /></td>

							<td><fmt:formatNumber value="${price}" pattern="###,###,###" />
								<s:text name="lang.cart.yen" /></td>

							<td><s:property value="order_count" /></td>

							<td><fmt:formatNumber value="${sub_total}"
									pattern="###,###,###" /> <s:text name="lang.cart.yen" /></td>

							<td><s:form action="UpdateCartAction">
									<s:hidden name="cart_id" value="%{cart_id}" />
									<s:hidden name="item_id" value="%{item_id}" />
									<s:hidden name="price" value="%{price}" />
									<div class="row">
										<select name="order_count">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
											<option>6</option>
											<option>7</option>
											<option>8</option>
											<option>9</option>
											<option>10</option>
										</select>
									</div>

									<div class="count">

										<input type="submit" class="btn btn-primary"
											value="<s:text name="lang.cart.update"/>" />
									</div>

								</s:form> <br> <br></td>

							<td><s:form action="DeleteCartAction"
									onSubmit="return no2click(this)">
									<!--  --<input id="order" type="hidden" name="order_count"
								value="<s:property value="order_count"/>">-->
									<s:hidden name="user_id" value="%{user_id}" />
									<s:hidden name="cart_id" value="%{cart_id}" />
									<button type="submit" class="btn btn-default">
										<s:text name="lang.cart.delete" />
									</button>

								</s:form></td>
						</tr>

					</s:iterator>

				</tbody>

			</table>

		</div>
		<!-- 購入ボタンフォーム -->
		<s:form action="GoPaymentAction">
			<button type="submit">購入する</button>
		</s:form>
	</div>
</body>
</html>