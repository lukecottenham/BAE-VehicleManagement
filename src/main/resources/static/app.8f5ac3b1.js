(function(e){function t(t){for(var a,o,i=t[0],l=t[1],u=t[2],d=0,m=[];d<i.length;d++)o=i[d],Object.prototype.hasOwnProperty.call(n,o)&&n[o]&&m.push(n[o][0]),n[o]=0;for(a in l)Object.prototype.hasOwnProperty.call(l,a)&&(e[a]=l[a]);c&&c(t);while(m.length)m.shift()();return s.push.apply(s,u||[]),r()}function r(){for(var e,t=0;t<s.length;t++){for(var r=s[t],a=!0,i=1;i<r.length;i++){var l=r[i];0!==n[l]&&(a=!1)}a&&(s.splice(t--,1),e=o(o.s=r[0]))}return e}var a={},n={app:0},s=[];function o(t){if(a[t])return a[t].exports;var r=a[t]={i:t,l:!1,exports:{}};return e[t].call(r.exports,r,r.exports,o),r.l=!0,r.exports}o.m=e,o.c=a,o.d=function(e,t,r){o.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:r})},o.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},o.t=function(e,t){if(1&t&&(e=o(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var r=Object.create(null);if(o.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var a in e)o.d(r,a,function(t){return e[t]}.bind(null,a));return r},o.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return o.d(t,"a",t),t},o.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},o.p="/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],l=i.push.bind(i);i.push=t,i=i.slice();for(var u=0;u<i.length;u++)t(i[u]);var c=l;s.push([0,"chunk-vendors"]),r()})({0:function(e,t,r){e.exports=r("56d7")},"039a":function(e,t,r){"use strict";var a=r("0d3c"),n=r.n(a);n.a},"0d3c":function(e,t,r){},"56d7":function(e,t,r){"use strict";r.r(t);r("e260"),r("e6cf"),r("cca6"),r("a79d");var a=r("2b0e"),n=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("v-app",[r("router-view"),r("v-app-bar",{attrs:{app:"",color:"primary",dark:""}},[r("div",{staticClass:"d-flex align-center"},[r("Navigation",{attrs:{color:"primary"}})],1),r("v-spacer")],1),r("v-content")],1)},s=[],o=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("b-navbar",{attrs:{toggleable:"lg"}},[r("b-navbar-brand",{on:{click:function(t){return e.home()}}},[e._v("Home")]),r("b-navbar-toggle",{attrs:{target:"nav-collapse"}}),r("b-collapse",{attrs:{id:"nav-collapse","is-nav":""}},[r("b-navbar-nav",[r("b-nav-item",{attrs:{to:{path:"signUp"}}},[e._v("Sign Up")]),r("b-nav-item",{attrs:{to:{path:"vehicleCard"}},on:{click:function(t){return e.clearVehicle()}}},[e._v("Vehicles")])],1),r("b-navbar-nav",{staticClass:"ml-auto"},[r("b-nav-item-dropdown",{attrs:{right:""},scopedSlots:e._u([{key:"button-content",fn:function(){return[r("em",[e._v("Account")])]},proxy:!0}])},[r("b-dropdown-item",{attrs:{to:{path:"/VehicleManagement/"}},on:{click:function(t){return e.signOut()}}},[e._v("Sign out")])],1)],1)],1)],1)],1)},i=[],l=(r("ac1f"),r("5319"),{name:"Navigation",data:function(){return{authenticated:!0,mockAccount:{username:"",password:""}}},mounted:function(){this.authenticated||this.$router.replace({name:"login"})},methods:{setAuthenticated:function(e){this.authenticated=e},emitUserId:function(){this.$store.commit("change",this.id),console.log(this.$store.getters.id)},clearVehicle:function(){this.$store.commit("vehicleSet",null),console.log(this.$store.getters.vehicleId),this.$router.replace(this.$route.query.redirect||"/VehicleManagement/vehicleCard")},signOut:function(){this.$store.commit("setAuthenticated",!1)},home:function(){this.$router.replace(this.$route.query.redirect||"/VehicleManagement/vehicleCard")}}}),u=l,c=r("2877"),d=Object(c["a"])(u,o,i,!1,null,null,null),m=d.exports,f={name:"App",components:{Navigation:m},data:function(){return{}}},v=f,p=r("6544"),h=r.n(p),g=r("7496"),b=r("40dc"),$=r("a75b"),x=r("2fa4"),k=Object(c["a"])(v,n,s,!1,null,null,null),y=k.exports;h()(k,{VApp:g["a"],VAppBar:b["a"],VContent:$["a"],VSpacer:x["a"]});var _=r("5f5b"),w=(r("f9e3"),r("2dd8"),r("bb35"),r("f309"));a["default"].use(w["a"]);var V=new w["a"]({}),D=r("8c4f"),C=function(){var e=this,t=e.$createElement,r=e._self._c||t;return e.renderComponent?r("div",{attrs:{id:"vehicleCard1"}},[e._l(e.results,(function(t){return r("div",{key:t.id,attrs:{id:"vLoop"}},[r("div",{attrs:{id:"vehicle"}},[r("b-card",{staticClass:"mb-2",staticStyle:{"max-width":"20rem"},attrs:{title:"Vehicle Details","img-src":"https://storage.kawasaki.eu/public/kawasaki.eu/en-EU/model/19ZX1000Y_201GY3DRS1CG_A.png","img-alt":"Image","img-top":"",tag:"article"}},[r("div",{attrs:{id:"vdetails"}},[r("ul",[e._v(" Make: "+e._s(t.make)+" ")]),r("ul",[e._v(" Model: "+e._s(t.model)+" ")]),r("ul",[e._v(" Tax Renewal Date: "+e._s(t.taxDate)+" ")]),r("ul",[e._v(" Insurance Renewaql Date: "+e._s(t.insuranceDate)+" ")]),r("ul",[e._v(" MOT Renewal Date: "+e._s(t.motDate)+" ")])]),r("b-card-text",[e._v(" Content of vehicle ")]),r("v-text-field",[e._v("textfield")]),r("b-button",{attrs:{variant:"primary"},on:{click:function(r){return e.storeVehicleId(t.id)}}},[e._v("View Issues")]),r("b-button",{attrs:{variant:"primary"},on:{click:function(r){return e.editVehicle(t.id)}}},[e._v("Edit Vehicle")]),r("b-button",{attrs:{variant:"primary"},on:{click:function(r){return e.deleteVehicle(t.id)}}},[e._v("Delete Vehicle")])],1)],1)])})),r("b-button",{attrs:{to:{path:"addVehicle"},variant:"primary"},on:{click:function(t){return e.addVehicle(e.vehicle.id)}}},[e._v("Add Vehicle")])],2):e._e()},q=[],A=new a["default"],I=r("bc3a"),M=r.n(I),S="http://3.8.223.175:8181/VehicleManagement/get/",N="http://3.8.223.175:8181/VehicleManagement/vehicle/",P={e1:"#vdetails",name:"VehicleCard",data:function(){return{renderComponent:!0,results:null,id:null}},created:function(){var e=this;M.a.get(S+this.$store.getters.id).then((function(t){e.results=t.data.vehicles}))},mounted:function(){},methods:{setVehicleId:function(e){return console.log(e),A.$emit("clicked-event",e),e},getVehicles:function(){var e=this;M.a.get(S+this.$store.getters.id).then((function(t){e.results=t.data.vehicles,console.log(t)}))},loadVehicles:function(e){var t=this;M.a.get(e).then((function(e){t.results=e.data[0].vehicles,console.log(e)}))},deleteVehicle:function(e){var t=this;M.a.delete(N+e).then((function(e){t.results=e.data,t.getVehicles(),console.log(e)}))},setVehicle:function(e){console.log("v"+e),this.$store.commit("vehicleSet",e),console.log(this.$store.getters.vehicleId),console.log()},storeVehicleId:function(e){this.$store.commit("vehicleSet",e),console.log("vid"+this.$store.getters.vehicleId),this.$router.replace(this.$route.query.redirect||"/VehicleManagement/issue")},editVehicle:function(e){this.$store.commit("vehicleSet",e),this.$router.replace(this.$route.query.redirect||"/VehicleManagement/editVehicle")}}},O=P,E=r("8654"),R=Object(c["a"])(O,C,q,!1,null,null,null),j=R.exports;h()(R,{VTextField:E["a"]});var U=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"signUpForm"}},[r("v-form",{model:{value:e.isValid,callback:function(t){e.isValid=t},expression:"isValid"}},[r("v-text-field",{attrs:{label:"First Name",rules:[e.rules.required],type:"String"},on:{change:function(t){return e.checkEmpty(t,"name")}},model:{value:e.form.firstName,callback:function(t){e.$set(e.form,"firstName",t)},expression:"form.firstName"}}),r("v-text-field",{attrs:{label:"Surname",rules:[e.rules.required]},model:{value:e.form.surname,callback:function(t){e.$set(e.form,"surname",t)},expression:"form.surname"}}),r("v-text-field",{attrs:{label:"Postcode",rules:[e.rules.required]},model:{value:e.form.postcode,callback:function(t){e.$set(e.form,"postcode",t)},expression:"form.postcode"}}),r("v-text-field",{attrs:{label:"E-mail Address",rules:[e.rules.required,e.rules.email]},model:{value:e.form.email,callback:function(t){e.$set(e.form,"email",t)},expression:"form.email"}}),r("v-text-field",{attrs:{label:"Confirm E-mail",rules:[e.rules.required,e.rules.email,e.emailConfirmationRule]},model:{value:e.form.cEmail,callback:function(t){e.$set(e.form,"cEmail",t)},expression:"form.cEmail"}}),r("v-text-field",{attrs:{label:"Password",rules:[e.rules.required]},model:{value:e.form.password,callback:function(t){e.$set(e.form,"password",t)},expression:"form.password"}}),r("v-text-field",{attrs:{label:"Confirm Password",rules:[e.rules.required,e.passwordConfirmationRule]},model:{value:e.form.cPassword,callback:function(t){e.$set(e.form,"cPassword",t)},expression:"form.cPassword"}})],1),r("b-button",{staticClass:"btn",attrs:{href:"#",variant:"outline-primary",disabled:!e.isValid},on:{click:function(t){return e.postPost()}}},[e._v("Submit")])],1)},T=[],F="http://3.8.223.175:8181/VehicleManagement/user",B={data:function(){return{isValid:!0,form:{email:null,cEmail:null,password:null,cPassword:null,firstName:null,surname:null,postcode:null},rules:{required:function(e){return!!e||"Required."},min:function(e){return e.length>=8||"Min 8 characters"},email:function(e){return/.+@.+/.test(e)||"E-mail must be valid"},uppercase:function(e){return/(?=.*[A-Z])/.test(e)||"Must have one uppercase character"},oneNumber:function(e){return/(?=.*\d)/.test(e)||"Must have one number"},special:function(e){return/([!@$%])/.test(e)||"Must have one special character [!@#$%]"}}}},name:"SignUp",methods:{postPost:function(){var e=this;M.a.post(F,this.form).then((function(t){console.log(t),e.$router.replace(e.$route.query.redirect||"/VehicleManagement/signUp")})).catch((function(t){e.errors.push(t)}))}},computed:{passwordConfirmationRule:function(){return this.form.password===this.form.cPassword||"Passwords must match"},emailConfirmationRule:function(){return this.form.email===this.form.cEmail||"Emails must match"}}},L=B,K=r("4bd4"),W=Object(c["a"])(L,U,T,!1,null,null,null),J=W.exports;h()(W,{VForm:K["a"],VTextField:E["a"]});var Y=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"vehicleCard"}},[r("h1",{staticClass:"title"},[e._v("Create Account")]),r("h2",{staticClass:"subtitle"},[e._v(" Create an account or log in to manage your vehicles ")]),r("form",{staticClass:"form"},[r("div",{staticClass:"form-group"},[r("label",{staticClass:"form-label",attrs:{for:"name"}},[e._v("First Name")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.$v.form.firstName.$model,expression:"$v.form.firstName.$model"}],staticClass:"form-control",attrs:{type:"text",placeholder:"Name",id:"name"},domProps:{value:e.$v.form.firstName.$model},on:{input:function(t){t.target.composing||e.$set(e.$v.form.firstName,"$model",t.target.value)}}})]),r("div",{staticClass:"form-group"},[r("label",{staticClass:"form-label",attrs:{for:"name"}},[e._v("Surname")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.$v.form.surname.$model,expression:"$v.form.surname.$model"}],staticClass:"form-control",attrs:{type:"text",placeholder:"Name",id:"name"},domProps:{value:e.$v.form.surname.$model},on:{input:function(t){t.target.composing||e.$set(e.$v.form.surname,"$model",t.target.value)}}})]),r("div",{staticClass:"form-group"},[r("label",{staticClass:"form-label",attrs:{for:"email"}},[e._v("Email")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.$v.form.email.$model,expression:"$v.form.email.$model"}],staticClass:"form-control",attrs:{type:"text",placeholder:"your@email.com",id:"email"},domProps:{value:e.$v.form.email.$model},on:{input:function(t){t.target.composing||e.$set(e.$v.form.email,"$model",t.target.value)}}})]),r("div",{staticClass:"form-group"},[r("label",{staticClass:"form-label",attrs:{for:"password"}},[e._v("Password")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.$v.form.password.$model,expression:"$v.form.password.$model"}],staticClass:"form-control",attrs:{type:"password",placeholder:"Password",id:"password"},domProps:{value:e.$v.form.password.$model},on:{input:function(t){t.target.composing||e.$set(e.$v.form.password,"$model",t.target.value)}}})]),r("div",{staticClass:"form-group"},[r("label",{staticClass:"form-label",attrs:{for:"password"}},[e._v("Re-enter Password")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.$v.form.passwordConf.$model,expression:"$v.form.passwordConf.$model"}],staticClass:"form-control",attrs:{type:"password",placeholder:"Password",id:"password"},domProps:{value:e.$v.form.passwordConf.$model},on:{input:function(t){t.target.composing||e.$set(e.$v.form.passwordConf,"$model",t.target.value)}}})]),r("div",{staticClass:"form-group"},[r("label",{staticClass:"form-label",attrs:{for:"postcode"}},[e._v("Postcode")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.form.postcode,expression:"form.postcode"}],staticClass:"form-control",attrs:{type:"text",placeholder:"Postcode",id:"postcode"},domProps:{value:e.form.postcode},on:{input:function(t){t.target.composing||e.$set(e.form,"postcode",t.target.value)}}})])]),r("button",{staticClass:"btn",on:{click:function(t){return e.postPost()}}},[e._v("submit")])])},G=[],Z=r("b5ae"),z="http://3.8.223.175:8181/VehicleManagement/user",H={name:"Register",data:function(){return{form:{email:null,password:null,passwordConf:null,firstName:null,surname:null,postcode:null}}},validations:{form:{email:{required:Z["required"],email:Z["email"]},password:{required:Z["required"]},passwordConf:{required:Z["required"]},firstName:{required:Z["required"]},surname:{required:Z["required"]},postcode:{required:Z["required"]}}},methods:{postPost:function(){var e=this;M.a.post(z,this.form).then((function(e){console.log(e)})).catch((function(t){e.errors.push(t)}))}}},X=H,Q=Object(c["a"])(X,Y,G,!1,null,null,null),ee=Q.exports,te=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"vehicleCard"}},[r("b-table",{attrs:{striped:"",hover:"",items:e.items,fields:e.fields},on:{"row-clicked":e.rowSelected},scopedSlots:e._u([{key:"cell(is_addressed)",fn:function(t){return[r("b-form-checkbox",{ref:"checked",on:{change:t.toggleDetails},model:{value:t.detailsShowing,callback:function(r){e.$set(t,"detailsShowing",r)},expression:"row.detailsShowing"}},[e._v(" Issue Addressed ")])]}}])}),r("b-button",{attrs:{to:{path:"addIssue"},variant:"primary"}},[e._v("Add Issue")]),r("b-button",{attrs:{to:{path:"editIssue"},variant:"primary"},on:{click:function(t){return e.setIssueId()}}},[e._v("Edit Issue")]),r("b-button",{attrs:{variant:"primary"},on:{click:e.showModal}},[e._v("Delete Issue")]),r("b-button",{attrs:{variant:"primary"},on:{click:function(t){return e.vehicles()}}},[e._v("Vehicles")]),r("b-button",{attrs:{variant:"primary"},on:{click:function(t){return e.issueAddressed()}}},[e._v("Confirm Update")]),r("b-modal",{ref:"my-modal",attrs:{"hide-footer":"",title:"Delete Issue"}},[r("div",{staticClass:"d-block text-center"},[r("h3",[e._v("Are you sure you would like to delete this issue?")])]),r("b-button",{staticClass:"mt-3",attrs:{variant:"outline-danger",block:""},on:{click:e.hideModal}},[e._v("No")]),r("b-button",{staticClass:"mt-2",attrs:{variant:"outline-warning",block:""},on:{click:e.deleteModal}},[e._v("Yes, delete")])],1)],1)},re=[],ae="http://3.8.223.175:8181/VehicleManagement/getVehicle/",ne="http://3.8.223.175:8181/VehicleManagement/issue/",se="http://3.8.223.175:8181/VehicleManagement/updateAddressed/",oe={name:"Issue",data:function(){return{results:null,fields:["issueName","lastAddressed","urgency","is_addressed"],items:[{id:null,issueName:null,lastAdressed:null,urgency:null}]}},created:function(){var e=this;M.a.get(ae+this.$store.getters.vehicleId).then((function(t){e.items=t.data.issues}))},mounted:function(){},methods:{showModal:function(){this.$refs["my-modal"].show()},hideModal:function(){this.$refs["my-modal"].hide()},deleteModal:function(){this.deleteIssue(),this.$refs["my-modal"].hide(),this.getIssues()},rowSelected:function(e){this.items.id=e.id,this.$store.commit("setIssue",this.items.id),this.$store.commit("setIssueName",this.items.issueName),this.$store.commit("setUrgency",this.items.urgency),console.log("iiid"+this.$store.getters.issueName)},setIssueId:function(){A.$emit("clicked-issue",this.items.id)},getIssues:function(){var e=this;M.a.get(ae+this.$store.getters.vehicleId).then((function(t){e.items=t.data.issues}))},deleteIssue:function(){var e=this;M.a.delete(ne+this.$store.getters.issueId).then((function(t){e.items=t.data,e.getIssues()}))},vehicles:function(){this.$router.replace(this.$route.query.redirect||"/VehicleManagement/vehicleCard")},addressBy:function(){this.items.addressBy=this.items.lastAdressed,console.log(this.items.lastAddressed)},issueAddressed:function(){var e=this;if(this.$refs["checked"]){this.items.lastAdressed=(new Date).toISOString().substr(0,10),console.log(this.items.issueName);var t={lastAddressed:this.items.lastAdressed};JSON.stringify(t),console.log(this.items.lastAdressed),M.a.patch(se+this.$store.getters.issueId,t).then((function(e){console.log("patch"+e)})).catch((function(t){e.errors.push(t)}))}}},computed:{}},ie=oe,le=Object(c["a"])(ie,te,re,!1,null,null,null),ue=le.exports,ce=r("1dce"),de=r.n(ce),me=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"vehicleCard"}},[r("h1",{staticClass:"title"},[e._v("Add a Vehicle")]),r("form",{staticClass:"form"},[r("div",{staticClass:"form-group"},[r("label",{staticClass:"form-label",attrs:{for:"make"}},[e._v("Make")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.$v.form.make.$model,expression:"$v.form.make.$model"}],staticClass:"form-control",attrs:{type:"text",placeholder:"make",id:"make"},domProps:{value:e.$v.form.make.$model},on:{input:function(t){t.target.composing||e.$set(e.$v.form.make,"$model",t.target.value)}}})]),r("div",{staticClass:"form-group"},[r("label",{staticClass:"form-label",attrs:{for:"model"}},[e._v("Model")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.$v.form.model.$model,expression:"$v.form.model.$model"}],staticClass:"form-control",attrs:{type:"text",placeholder:"model",id:"model"},domProps:{value:e.$v.form.model.$model},on:{input:function(t){t.target.composing||e.$set(e.$v.form.model,"$model",t.target.value)}}})]),r("v-menu",{ref:"menu1",attrs:{"close-on-content-click":!1,"return-value":e.form.taxDate,transition:"scale-transition","offset-y":"","min-width":"290px"},on:{"update:returnValue":function(t){return e.$set(e.form,"taxDate",t)},"update:return-value":function(t){return e.$set(e.form,"taxDate",t)}},scopedSlots:e._u([{key:"activator",fn:function(t){var a=t.on;return[r("v-text-field",e._g({attrs:{label:"Tax Renewal Date",readonly:""},model:{value:e.form.taxDate,callback:function(t){e.$set(e.form,"taxDate",t)},expression:"form.taxDate"}},a))]}}]),model:{value:e.menu1,callback:function(t){e.menu1=t},expression:"menu1"}},[r("v-date-picker",{attrs:{"no-title":"",scrollable:""},model:{value:e.form.taxDate,callback:function(t){e.$set(e.form,"taxDate",t)},expression:"form.taxDate"}},[r("v-spacer"),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){e.menu1=!1}}},[e._v("Cancel")]),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){return e.$refs.menu1.save(e.form.taxDate)}}},[e._v("OK")])],1)],1),r("v-menu",{ref:"menu",attrs:{"close-on-content-click":!1,"return-value":e.form.insuranceDate,transition:"scale-transition","offset-y":"","min-width":"290px"},on:{"update:returnValue":function(t){return e.$set(e.form,"insuranceDate",t)},"update:return-value":function(t){return e.$set(e.form,"insuranceDate",t)}},scopedSlots:e._u([{key:"activator",fn:function(t){var a=t.on;return[r("v-text-field",e._g({attrs:{label:"Insurance Renewal Date",readonly:""},model:{value:e.form.insuranceDate,callback:function(t){e.$set(e.form,"insuranceDate",t)},expression:"form.insuranceDate"}},a))]}}]),model:{value:e.menu,callback:function(t){e.menu=t},expression:"menu"}},[r("v-date-picker",{attrs:{"no-title":"",scrollable:""},model:{value:e.form.insuranceDate,callback:function(t){e.$set(e.form,"insuranceDate",t)},expression:"form.insuranceDate"}},[r("v-spacer"),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){e.menu=!1}}},[e._v("Cancel")]),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){return e.$refs.menu.save(e.form.insuranceDate)}}},[e._v("OK")])],1)],1),r("v-menu",{ref:"menu2",attrs:{"close-on-content-click":!1,"return-value":e.form.motDate,transition:"scale-transition","offset-y":"","min-width":"290px"},on:{"update:returnValue":function(t){return e.$set(e.form,"motDate",t)},"update:return-value":function(t){return e.$set(e.form,"motDate",t)}},scopedSlots:e._u([{key:"activator",fn:function(t){var a=t.on;return[r("v-text-field",e._g({attrs:{label:"MOT Renewal Date",readonly:""},model:{value:e.form.motDate,callback:function(t){e.$set(e.form,"motDate",t)},expression:"form.motDate"}},a))]}}]),model:{value:e.menu2,callback:function(t){e.menu2=t},expression:"menu2"}},[r("v-date-picker",{attrs:{"no-title":"",scrollable:""},model:{value:e.form.motDate,callback:function(t){e.$set(e.form,"motDate",t)},expression:"form.motDate"}},[r("v-spacer"),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){e.menu2=!1}}},[e._v("Cancel")]),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){return e.$refs.menu2.save(e.form.motDate)}}},[e._v("OK")])],1)],1),r("div",{staticClass:"file-upload-form"},[e._v(" Upload an image file for the vehicle: "),r("input",{attrs:{type:"file",accept:"image/*"},on:{change:e.previewImage}})]),e.imageData.length>0?r("div",{staticClass:"image-preview"},[r("img",{staticClass:"preview",attrs:{src:e.imageData}})]):e._e()],1),r("button",{staticClass:"btn",on:{click:function(t){return e.postPost()}}},[e._v("submit")])])},fe=[],ve="http://3.8.223.175:8181/VehicleManagement/update/",pe={name:"AddVehicle",data:function(){return{form:{make:null,model:null,motDate:(new Date).toISOString().substr(0,10),insuranceDate:(new Date).toISOString().substr(0,10),taxDate:(new Date).toISOString().substr(0,10)},menu:!1,menu1:!1,menu2:!1,imageData:""}},validations:{form:{make:{required:Z["required"]},model:{required:Z["required"]},taxDate:{required:Z["required"]},motDate:{required:Z["required"]},insuranceDate:{required:Z["required"]}}},created:function(){},methods:{postPost:function(){var e=this;M.a.patch(ve+this.$store.getters.id,this.form).then((function(e){console.log(e)})).catch((function(t){e.errors.push(t)})),this.$router.replace(this.$route.query.redirect||"/VehicleManagement/vehicleCard")}}},he=pe,ge=r("8336"),be=r("2e4b"),$e=r("e449"),xe=Object(c["a"])(he,me,fe,!1,null,"dd04ac3c",null),ke=xe.exports;h()(xe,{VBtn:ge["a"],VDatePicker:be["a"],VMenu:$e["a"],VSpacer:x["a"],VTextField:E["a"]});var ye=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"vehicleCard"}},[r("h1",{staticClass:"title"},[e._v("Add an Issue")]),r("form",{staticClass:"form"},[r("div",{staticClass:"form-group"},[r("label",{staticClass:"form-label",attrs:{for:"name"}},[e._v("Issue Name")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.$v.form.issueName.$model,expression:"$v.form.issueName.$model"}],staticClass:"form-control",attrs:{type:"text",placeholder:"Name",id:"name"},domProps:{value:e.$v.form.issueName.$model},on:{input:function(t){t.target.composing||e.$set(e.$v.form.issueName,"$model",t.target.value)}}})]),r("div",{staticClass:"form-group"},[r("b-form-select",{attrs:{options:e.options},model:{value:e.form.urgency,callback:function(t){e.$set(e.form,"urgency",t)},expression:"form.urgency"}})],1),r("v-menu",{ref:"menu",attrs:{"close-on-content-click":!1,"return-value":e.form.lastAddressed,transition:"scale-transition","offset-y":"","min-width":"290px"},on:{"update:returnValue":function(t){return e.$set(e.form,"lastAddressed",t)},"update:return-value":function(t){return e.$set(e.form,"lastAddressed",t)}},scopedSlots:e._u([{key:"activator",fn:function(t){var a=t.on;return[r("v-text-field",e._g({attrs:{label:"Last Addressed",readonly:""},model:{value:e.form.lastAddressed,callback:function(t){e.$set(e.form,"lastAddressed",t)},expression:"form.lastAddressed"}},a))]}}]),model:{value:e.menu,callback:function(t){e.menu=t},expression:"menu"}},[r("v-date-picker",{attrs:{"no-title":"",scrollable:""},model:{value:e.form.lastAddressed,callback:function(t){e.$set(e.form,"lastAddressed",t)},expression:"form.lastAddressed"}},[r("v-spacer"),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){e.menu=!1}}},[e._v("Cancel")]),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){return e.$refs.menu.save(e.form.lastAddressed)}}},[e._v("OK")])],1)],1)],1),r("v-btn",{staticClass:"btn",on:{click:function(t){return e.postPost()}}},[e._v("submit")])],1)},_e=[],we="http://3.8.223.175:8181/VehicleManagement/addIssue/",Ve={name:"AddIssue",data:function(){return{form:{issueName:null,urgency:null,lastAddressed:(new Date).toISOString().substr(0,10)},menu:!1,options:[{value:null,text:"Please select an option"},{value:"1 day",text:"Daily"},{value:"1 week",text:"Weekly"},{value:"2 weeks",text:"Bi-Weekly"},{value:"1 month",text:"Monthly"},{value:"6 months",text:"Semi-Annualy"},{value:"1 year",text:"Annualy"}]}},validations:{form:{issueName:{required:Z["required"]},selected:{required:Z["required"]},lastAddressed:{required:Z["required"]}}},methods:{postPost:function(){var e=this;M.a.patch(we+this.$store.getters.vehicleId,this.form).then((function(t){e.$router.replace(e.$route.query.redirect||"/VehicleManagement/issue"),console.log(t)})).catch((function(t){e.errors.push(t)}))}}},De=Ve,Ce=Object(c["a"])(De,ye,_e,!1,null,"040dff6f",null),qe=Ce.exports;h()(Ce,{VBtn:ge["a"],VDatePicker:be["a"],VMenu:$e["a"],VSpacer:x["a"],VTextField:E["a"]});var Ae=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"vehicleCard"}},[r("h1",{staticClass:"title"},[e._v("Edit Issue")]),r("form",{staticClass:"form"},[r("v-text-field",{attrs:{label:"Issue Name",placeholder:e.results.issueName,rules:[e.rules.required]},model:{value:e.form.issueName,callback:function(t){e.$set(e.form,"issueName",t)},expression:"form.issueName"}}),r("div",{staticClass:"form-group"},[r("b-form-select",{attrs:{options:e.options},model:{value:e.form.urgency,callback:function(t){e.$set(e.form,"urgency",t)},expression:"form.urgency"}})],1),r("v-menu",{ref:"menu",attrs:{"close-on-content-click":!1,"return-value":e.form.lastAddressed,transition:"scale-transition","offset-y":"","min-width":"290px"},on:{"update:returnValue":function(t){return e.$set(e.form,"lastAddressed",t)},"update:return-value":function(t){return e.$set(e.form,"lastAddressed",t)}},scopedSlots:e._u([{key:"activator",fn:function(t){var a=t.on;return[r("v-text-field",e._g({attrs:{label:"Last Addressed",readonly:""},model:{value:e.form.lastAddressed,callback:function(t){e.$set(e.form,"lastAddressed",t)},expression:"form.lastAddressed"}},a))]}}]),model:{value:e.menu,callback:function(t){e.menu=t},expression:"menu"}},[r("v-date-picker",{attrs:{"no-title":"",scrollable:""},model:{value:e.form.lastAddressed,callback:function(t){e.$set(e.form,"lastAddressed",t)},expression:"form.lastAddressed"}},[r("v-spacer"),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){e.menu=!1}}},[e._v("Cancel")]),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){return e.$refs.menu.save(e.form.lastAddressed)}}},[e._v("OK")])],1)],1)],1),r("v-btn",{staticClass:"btn",on:{click:function(t){return e.postPost()}}},[e._v("submit")])],1)},Ie=[],Me="http://3.8.223.175:8181/VehicleManagement/getIssue/",Se="http://3.8.223.175:8181/VehicleManagement/updateIssue/",Ne={name:"EditIssue",data:function(){return{rules:{required:function(e){return!!e||"Required."},min:function(e){return e.length>=8||"Min 8 characters"},message:"One lowercase letter required.",email:function(e){return/.+@.+/.test(e)||"E-mail must be valid"}},results:null,form:{issueName:null,urgency:null,lastAddressed:(new Date).toISOString().substr(0,10)},menu:!1,options:[{value:null,text:"Please select an option "},{value:"1",text:"Daily"},{value:"7",text:"Weekly"},{value:"14",text:"Bi-Weekly"},{value:"30",text:"Monthly"},{value:"182",text:"Semi-Annualy"},{value:"365",text:"Annualy"}]}},created:function(){var e=this;A.$on("clicked-issue",(function(t){console.log(t),e.getIssue(Me+t)}))},mounted:function(){},validations:{form:{issueName:{required:Z["required"]},selected:{required:Z["required"]},lastAddressed:{required:Z["required"]}}},methods:{postPost:function(){var e=this;console.log(this.$store.getters.issueId),M.a.patch(Se+this.$store.getters.issueId,this.form).then((function(e){console.log("patch"+e)})).catch((function(t){e.errors.push(t)})),this.$router.replace(this.$route.query.redirect||"/VehicleManagement/issue")},getIssue:function(e){var t=this;M.a.get(e).then((function(e){t.results=e.data,console.log("123"+e)}))}}},Pe=Ne,Oe=Object(c["a"])(Pe,Ae,Ie,!1,null,"032abb8c",null),Ee=Oe.exports;h()(Oe,{VBtn:ge["a"],VDatePicker:be["a"],VMenu:$e["a"],VSpacer:x["a"],VTextField:E["a"]});var Re=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"vehicleCard"}},[r("h1",{staticClass:"title"},[e._v("Edit Vehicle")]),r("form",{staticClass:"form"},[r("v-text-field",{attrs:{label:"Make",placeholder:e.results.make,rules:[e.rules.required,e.rules.min]},model:{value:e.form.make,callback:function(t){e.$set(e.form,"make",t)},expression:"form.make"}}),r("v-text-field",{attrs:{label:"Model",placeholder:e.results.model,rules:[e.rules.required,e.rules.min]},model:{value:e.form.model,callback:function(t){e.$set(e.form,"model",t)},expression:"form.model"}}),r("v-menu",{ref:"menu1",attrs:{"close-on-content-click":!1,"return-value":e.form.taxDate,transition:"scale-transition","offset-y":"","min-width":"290px"},on:{"update:returnValue":function(t){return e.$set(e.form,"taxDate",t)},"update:return-value":function(t){return e.$set(e.form,"taxDate",t)}},scopedSlots:e._u([{key:"activator",fn:function(t){var a=t.on;return[r("v-text-field",e._g({attrs:{label:"Tax Renewal Date",readonly:"",rules:[e.rules.required]},model:{value:e.form.taxDate,callback:function(t){e.$set(e.form,"taxDate",t)},expression:"form.taxDate"}},a))]}}]),model:{value:e.menu1,callback:function(t){e.menu1=t},expression:"menu1"}},[r("v-date-picker",{attrs:{"no-title":"",scrollable:""},model:{value:e.form.taxDate,callback:function(t){e.$set(e.form,"taxDate",t)},expression:"form.taxDate"}},[r("v-spacer"),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){e.menu1=!1}}},[e._v("Cancel")]),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){return e.$refs.menu1.save(e.form.taxDate)}}},[e._v("OK")])],1)],1),r("v-menu",{ref:"menu",attrs:{"close-on-content-click":!1,"return-value":e.form.insuranceDate,transition:"scale-transition","offset-y":"","min-width":"290px"},on:{"update:returnValue":function(t){return e.$set(e.form,"insuranceDate",t)},"update:return-value":function(t){return e.$set(e.form,"insuranceDate",t)}},scopedSlots:e._u([{key:"activator",fn:function(t){var a=t.on;return[r("v-text-field",e._g({attrs:{label:"Insurance Renewal Date",readonly:"",rules:[e.rules.required]},model:{value:e.form.insuranceDate,callback:function(t){e.$set(e.form,"insuranceDate",t)},expression:"form.insuranceDate"}},a))]}}]),model:{value:e.menu,callback:function(t){e.menu=t},expression:"menu"}},[r("v-date-picker",{attrs:{"no-title":"",scrollable:""},model:{value:e.form.insuranceDate,callback:function(t){e.$set(e.form,"insuranceDate",t)},expression:"form.insuranceDate"}},[r("v-spacer"),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){e.menu=!1}}},[e._v("Cancel")]),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){return e.$refs.menu.save(e.form.insuranceDate)}}},[e._v("OK")])],1)],1),r("v-menu",{ref:"menu2",attrs:{"close-on-content-click":!1,"return-value":e.form.motDate,transition:"scale-transition","offset-y":"","min-width":"290px"},on:{"update:returnValue":function(t){return e.$set(e.form,"motDate",t)},"update:return-value":function(t){return e.$set(e.form,"motDate",t)}},scopedSlots:e._u([{key:"activator",fn:function(t){var a=t.on;return[r("v-text-field",e._g({attrs:{label:"MOT Renewal Date",readonly:"",rules:[e.rules.required]},model:{value:e.form.motDate,callback:function(t){e.$set(e.form,"motDate",t)},expression:"form.motDate"}},a))]}}]),model:{value:e.menu2,callback:function(t){e.menu2=t},expression:"menu2"}},[r("v-date-picker",{attrs:{"no-title":"",scrollable:""},model:{value:e.form.motDate,callback:function(t){e.$set(e.form,"motDate",t)},expression:"form.motDate"}},[r("v-spacer"),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){e.menu2=!1}}},[e._v("Cancel")]),r("v-btn",{attrs:{text:"",color:"primary"},on:{click:function(t){return e.$refs.menu2.save(e.form.motDate)}}},[e._v("OK")])],1)],1)],1),r("button",{staticClass:"btn",on:{click:function(t){return e.postPost()}}},[e._v("submit")])])},je=[],Ue="http://3.8.223.175:8181/VehicleManagement/getVehicle/",Te="http://3.8.223.175:8181/VehicleManagement/updateVehicle/",Fe={name:"EditVehicle",data:function(){return{results:null,form:{id:null,make:null,model:null,motDate:(new Date).toISOString().substr(0,10),insuranceDate:(new Date).toISOString().substr(0,10),taxDate:(new Date).toISOString().substr(0,10)},menu:!1,menu1:!1,menu2:!1,imageData:"",rules:{required:function(e){return!!e||"Required."},min:function(e){return e.length>=8||"Min 3 characters"}}}},mounted:function(){},validations:{form:{make:{required:Z["required"]},model:{required:Z["required"]},taxDate:{required:Z["required"]},motDate:{required:Z["required"]},insuranceDate:{required:Z["required"]}}},created:function(){this.getVehicle(Ue+this.$store.getters.vehicleId)},methods:{postPost:function(){var e=this;M.a.patch(Te+this.results.id,this.form).then((function(e){console.log(e)})).catch((function(t){e.errors.push(t)})),this.$router.replace(this.$route.query.redirect||"/VehicleManagement/vehicleCard")},getVehicle:function(e){var t=this;M.a.get(e).then((function(e){t.results=e.data}))}},computed:{id:function(){return this.results.id}}},Be=Fe,Le=Object(c["a"])(Be,Re,je,!1,null,"7f46bfd4",null),Ke=Le.exports;h()(Le,{VBtn:ge["a"],VDatePicker:be["a"],VMenu:$e["a"],VSpacer:x["a"],VTextField:E["a"]});var We=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"login-wrapper border border-light"},[r("form",{staticClass:"form-signin",on:{submit:function(t){return t.preventDefault(),e.login(t)}}},[r("h2",{staticClass:"form-signin-heading"},[e._v("Please sign in")]),e.error?r("div",{staticClass:"alert alert-danger"},[e._v(e._s(e.error))]):e._e(),r("label",{staticClass:"sr-only",attrs:{for:"inputEmail"}},[e._v("Email address")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.email,expression:"email"}],staticClass:"form-control",attrs:{type:"email",id:"inputEmail",placeholder:"Email address",required:"",autofocus:""},domProps:{value:e.email},on:{input:function(t){t.target.composing||(e.email=t.target.value)}}}),r("label",{staticClass:"sr-only",attrs:{for:"inputPassword"}},[e._v("Password")]),r("input",{directives:[{name:"model",rawName:"v-model",value:e.password,expression:"password"}],staticClass:"form-control",attrs:{type:"password",id:"inputPassword",placeholder:"Password",required:""},domProps:{value:e.password},on:{input:function(t){t.target.composing||(e.password=t.target.value)}}}),r("button",{staticClass:"btn btn-lg btn-primary btn-block",attrs:{type:"submit"},on:{click:function(t){return e.emitUserId()}}},[e._v("Sign in")]),r("button",{staticClass:"btn btn-lg btn-primary btn-block",attrs:{type:"submit"},on:{click:function(t){return e.register()}}},[e._v("Register")])])])},Je=[],Ye=(r("4160"),r("159b"),{name:"Login",data:function(){return{id:null,email:"",password:"",error:!1}},methods:{login:function(){var e=this;this.axios.get("user").then((function(t){t.data.forEach((function(t){t.email===e.email&&t.password===e.password?(e.id=t.id,e.$store.commit("setAuthenticated",!0),e.$router.replace(e.$route.query.redirect||"/VehicleManagement/vehicleCard"),e.emitUserId(e.id)):e.loginFailed()}))}))},loginSuccessful:function(){},loginFailed:function(){this.error="Login failed!",delete localStorage.token},emitUserId:function(){this.$store.commit("change",this.id),console.log(this.$store.getters.id)},register:function(){this.$router.replace(this.$route.query.redirect||"/VehicleManagement/signUp")}}}),Ge=Ye,Ze=(r("039a"),Object(c["a"])(Ge,We,Je,!1,null,null,null)),ze=Ze.exports,He=r("a7fe"),Xe=r.n(He),Qe=Object({NODE_ENV:"production",BASE_URL:"/"}).API_URL||"http://3.8.223.175:8181/VehicleManagement/",et=M.a.create({baseURL:Qe,headers:{"Content-Type":"application/json",Authorization:"Bearer "+localStorage.token}});a["default"].use(Xe.a,et);var tt=r("2f62");a["default"].use(tt["a"]);var rt=new tt["a"].Store({state:{id:null,vehicleId:null,issueId:null,userName:null,isAuthenticated:!1,issueName:null,issueUrgency:null},mutations:{change:function(e,t){e.id=t},vehicleSet:function(e,t){e.vehicleId=t},setIssue:function(e,t){e.issueId=t},setUserName:function(e,t){e.userName=t},setAuthenticated:function(e,t){e.isAuthenticated=t},setIssueName:function(e,t){e.issueName=t},setUrgency:function(e,t){e.urgency=t}},getters:{id:function(e){return e.id},vehicleId:function(e){return e.vehicleId},issueId:function(e){return e.issueId},userName:function(e){return e.userName},isAuthenticated:function(e){return e.isAuthenticated},issueName:function(e){return e.issueName},urgency:function(e){return e.urgency}}});a["default"].use(de.a),a["default"].use(_["a"]),a["default"].use(D["a"]),a["default"].config.productionTip=!1;var at=new D["a"]({mode:"history",routes:[{path:"/VehicleManagement/vehicleCard",component:j,beforeEnter:function(e,t,r){rt.state.isAuthenticated?r():r("/")}},{path:"/VehicleManagement/signUp",component:J},{path:"/VehicleManagement/register",component:ee},{path:"/VehicleManagement/issue",component:ue,beforeEnter:function(e,t,r){rt.state.isAuthenticated?r():r("/")}},{path:"/VehicleManagement/addVehicle",component:ke,beforeEnter:function(e,t,r){rt.state.isAuthenticated?r():r("/")}},{path:"/VehicleManagement/addIssue",component:qe,beforeEnter:function(e,t,r){rt.state.isAuthenticated?r():r("/")}},{path:"/VehicleManagement/editIssue",component:Ee,beforeEnter:function(e,t,r){rt.state.isAuthenticated?r():r("/")}},{path:"/VehicleManagement/editVehicle",component:Ke,beforeEnter:function(e,t,r){rt.state.isAuthenticated?r():r("/")}},{path:"/VehicleManagement/",name:"Login",component:ze}]});at.beforeEach((function(e,t,r){rt.state.isAuthenticated,r()})),new a["default"]({vuetify:V,router:at,axios:void 0,store:rt,render:function(e){return e(y)}}).$mount("#app")},bb35:function(e,t,r){}});
//# sourceMappingURL=app.8f5ac3b1.js.map