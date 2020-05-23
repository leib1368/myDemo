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

                    <el-popconfirm
                        confirmButtonText='好的'
                        cancelButtonText='不用了'
                        icon="el-icon-info"
                        iconColor="red"
                        title="确定删除吗？"
                        @onConfirm="handleDelete(scope.$index, scope.row)"
                    >
                        <el-button slot="reference" size="mini"
                                   type="danger" >Delete 删除</el-button>
                    </el-popconfirm>


                </template>
            </el-table-column>
        </el-table>

        <el-pagination
            layout="prev, pager, next, jumper   "
            :page-size="1"
            :total="50">
        </el-pagination>

        <el-button style="margin: 10px 0px;" type="success" size="mini" @click="saveInfo">添加</el-button>


        <transition name="el-zoom-in-center">
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
                        <el-button>取消</el-button>
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
                this.$http.get("http://localhost:8989/user/findAll").then(res => {
                    this.tableData = res.data;
                })
            }
        },
        created() {
            this.findAll();


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
