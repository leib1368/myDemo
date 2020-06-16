<template>
    <div>
        <el-table :height="300"
                  :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                  style="width: 100%">

            <el-table-column
                label="id"
                width="180">
                <template slot-scope="scope">
                    <!--        <i class="el-icon-time"></i>-->
                    <span style="margin-left: 10px">{{ scope.row.id }}</span>
                </template>
            </el-table-column>
            <el-table-column
                label="姓名"
                width="180">
                <template slot-scope="scope">
                    <!--hover 鼠标悬浮时显示-->
                    <el-popover trigger="hover" placement="top">
                        <p>姓名: {{ scope.row.name }}</p>
                        <p>住址: {{ scope.row.address }}</p>

                        <div slot="reference" class="name-wrapper">
                            <el-tag size="medium">{{ scope.row.name }}</el-tag>
                        </div>

                    </el-popover>
                </template>
            </el-table-column>
            <el-table-column label="生日" prop="bir"></el-table-column>
            <el-table-column label="性别" prop="sex"></el-table-column>
            <el-table-column label="地址" prop="address"></el-table-column>

            <el-table-column
                align="right">
                <template slot="header" slot-scope="scope">
                    <el-input
                        v-model="search"
                        size="mini"
                        placeholder="输入关键字搜索"/>
                </template>

                <template slot-scope="scope">
                    <el-button
                        size="mini"
                        @click="handleEdit(scope.$index, scope.row)">Edit
                    </el-button>

                    <!--气泡确认框 点击元素，弹出气泡确认框。-->
                    <el-popconfirm
                        confirmButtonText='好的'
                        cancelButtonText='不用了'
                        icon="el-icon-info"
                        iconColor="red"
                        title="确定删除吗？"
                        @onConfirm="handleDelete(scope.$index, scope.row)">
                        <!--点击确认时触发 ↑ -->
                        <el-button slot="reference" size="mini"
                                   type="danger" >Delete 删除</el-button>
                    </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>

        <!--分页-->
        <el-pagination
            layout="total, sizes, prev, pager, next, jumper"
            :page-size="size"
            :page-sizes="[1, 3, 7, 10]"
            :current-page="page"
            :total="totalPage"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
        >
        </el-pagination>

        <!--添加按钮-->
        <el-button style="margin: 10px 0px;" type="success" size="mini" @click="saveInfo">添加</el-button>

        <!--添加功能-->
        <!--非空处理 尚未完成-->
        <transition name="el-zoom-in-center">
            <!--transition内置过渡动画 show为真时显示-->
            <div v-show="show" class="transition-box">

                <el-form ref="form" :model="form" label-suffix=":" label-width="80px">
                    <el-form-item label="姓名">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>

                    <el-form-item label="生日">
                        <el-col :span="11">
                            <el-date-picker type="date" placeholder="选择日期" v-model="form.bir"
                                            style="width: 100%;"></el-date-picker>
                        </el-col>
                    </el-form-item>

                    <el-form-item label="性别">
                        <el-radio-group v-model="form.sex">
                            <el-radio label="男"></el-radio>
                            <el-radio label="女"></el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="地址">
                        <el-input type="textarea" v-model="form.address"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">保存用户</el-button>
                        <!--取消这个地方其实应该加一个show false以及清空数据-->
                        <el-button @click="onCancelButton">取消</el-button>
                    </el-form-item>
                </el-form>

            </div>
        </transition>

    </div>
</template>

<script>
    export default {
        name: 'List',
        data() {
            return {
                size: 3,
                page: 1,
                totalPage: 10,
                tableData: [],
                search: '',
                show: false,
                form: {
                    name: '',
                    bir: '',
                    sex: '男',
                    address: ''
                }
            }
        },
        methods: {
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
                this.size=val;
                this.findAll();
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
                this.page=val;
                this.findAll();
            },
            onCancelButton(){
                this.show = false ;
                this.form = {};
            },
            saveInfo(){
                if(this.show == false){
                    this.show = true ;
                    this.form = {};
                }else{
                    this.show = false ;
                }

            },
            handleEdit(index, row) {
                console.log(index, row);
                this.show = true ;
                this.form = row ;
            },
            handleDelete(index, row) {
                console.log(index, row);
                this.$http.get("http://localhost:8989/user/delete?id=" + row.id).then(res => {
                    if (res.data.status) {
                        this.$message({
                            message: "恭喜" + res.data.status,
                            type: 'success'
                        });
                        this.findAll();
                    } else {
                        this.$message.error(res.data.msg);

                    }
                })
            },
            onSubmit() {
                this.$http.post("http://localhost:8989/user/save", this.form).then(res => {
                    console.log('submit!');
                    if (res.data.status) {
                        this.$message({
                            message: "恭喜" + res.data.msg,
                            type: 'success'
                        });
                        this.form = {};
                        this.show = false;
                        this.findAll();
                    } else {
                        this.$message.error(res.data.msg);

                    }

                })
            },
            findAll() {
                this.$http.get("http://localhost:8989/user/findAll",{
                    params: {
                        page: this.page,
                        size: this.size
                    }
                }).then(res => {
                    this.tableData = res.data;
                    console.log('当前页'+this.page);
                    console.log('当前页大小'+this.size);
                })
            },
            findTotal() {
                this.$http.get("http://localhost:8989/user/findTotal",{

                }).then(res => {
                    console.log('1111--------1'+res.data);
                    this.totalPage = res.data;
                    console.log(res.data);
                })
            }
        },
        created() {
            this.findAll();
            this.findTotal();
        }

    }
</script>

<style>
    .transition-box {
        margin-bottom: 10px;
        width: 100%;
        height: 800px;
        border-radius: 4px;

        /*background-color: #409EFF;
        color: #fff;
        text-align: center;*/

        padding: 40px 20px;
        box-sizing: border-box;
        margin-right: 20px;
    }
</style>
